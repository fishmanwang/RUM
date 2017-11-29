/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.service.impl;

import com.google.common.base.Preconditions;
import com.mybatis.domain.PageBounds;
import com.rum.dao.UserDao;
import com.rum.dao.UserExtDao;
import com.rum.event.UserCreateEvent;
import com.rum.event.UserDeleteEvent;
import com.rum.exception.ApplicationException;
import com.rum.exception.CommonErrorCode;
import com.rum.exception.UserErrorCode;
import com.rum.facade.param.UserQueryParam;
import com.rum.facade.param.UserRegisterParam;
import com.rum.facade.vo.UserVo;
import com.rum.model.User;
import com.rum.model.UserExample;
import com.rum.service.EncryptionService;
import com.rum.service.UserService;
import com.rum.util.StringUtils;
import com.rum.utils.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户服务实现
 * 
 * @author tjwang
 * @version $Id: UserService.java, v 0.1 2017/8/4 0004 16:01 tjwang Exp $
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger            logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserDao           userDao;

    @Autowired
    private UserExtDao        userExtDao;

    @Autowired
    private EncryptionService encryptionService;

    @Override
    public void modifyPassword(Integer userId, String oldPwd, String newPwd, String newPwdConfirm) {

        checkConfirmPassword(newPwd, newPwdConfirm);
        User user = userDao.selectByPrimaryKey(userId);
        if (StringUtils.isNotBlank(oldPwd)) {
            String oldPwdMD5 = encryptionService.encryptPassword(oldPwd, user.getSalt());
            if (!user.getPassword().equals(oldPwdMD5)) {
                throw new ApplicationException(UserErrorCode.USER_PASSWORD_ERROR, "旧密码输入错误，请重新输入");
            }
        }

        String newPwdMD5 = encryptionService.encryptPassword(newPwd, user.getSalt());
        if (user.getPassword().equals(newPwdMD5)) {
            throw new ApplicationException(UserErrorCode.USER_PASSWORD_SAME_AS_OLD, "新密码不能与旧密码相同，请重新输入！");
        } else if (user.getUsername().equals(newPwd)) {
            throw new ApplicationException(UserErrorCode.USER_PASSWORD_SAME_AS_USERNAME, "新密码不能与账号相同，请重新输入！");
        } else {
            modifyPassword(userId, newPwdMD5);
            //userDao.modifyPassword(userId, newPwdMD5);
        }
    }

    @Override
    public void adminResetPassword(Integer userId, String salt, String newPwd, String newPwdConfirm, String administratorId) {
        // 首先检查管理员(administratorId)的权限

        checkConfirmPassword(newPwd, newPwdConfirm);
        String newPwdMD5 = encryptionService.encryptPassword(newPwd, salt);
        //userDao.modifyPassword(userId, newPwdMD5);// 记录初始化密码时间
        modifyPassword(userId, newPwdMD5);
    }

    private void modifyPassword(Integer userId, String newPwd) {
        User u = new User();
        u.setId(userId);
        u.setPassword(newPwd);
        userDao.updateByPrimaryKeySelective(u);
    }

    private void checkConfirmPassword(String newPwd, String newPwdConfirm) {
        if (StringUtils.isBlank(newPwd) || StringUtils.isBlank(newPwdConfirm)) {
            throw new ApplicationException(UserErrorCode.USER_PASSWORD_NULL, "新密码和确认密码不能为空！");
        }

        if (!newPwd.equals(newPwdConfirm)) {
            throw new ApplicationException(UserErrorCode.USER_PASSWORD_INCONSISTENT, "新密码和确认新密码不一致，请重新输入！");
        }
    }

    private User findUserByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> list = userDao.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {
        userDao.deleteByPrimaryKey(userId);

        UserDeleteEvent event = new UserDeleteEvent(userId);
        SpringContextHolder.getApplicationContext().publishEvent(event);
    }

    /**
     * 获取指定用户，并校验
     * @param userId
     * @return
     */
    private User getUser(Integer userId) {
        User user = userDao.selectByPrimaryKey(userId);
        if (user == null) {
            logger.warn("指定ID {} 不存在", userId);
            throw new ApplicationException(CommonErrorCode.PARAM_ERROR, "指定用户不存在");
        }
        return user;
    }

    @Override
    public Integer registerUser(UserRegisterParam param) {
        String username = param.getUsername();

        User u = findUserByUsername(username);
        if (u != null) {
            throw new ApplicationException(UserErrorCode.USER_USERNAME_EXIST);
        }

        String password = param.getPassword();
        String salt = StringUtils.getRandomString(6);
        String encryptedPwd = encryptionService.encryptPassword(password, salt);

        Date now = new Date();

        User user = new User();
        user.setUsername(username);
        user.setPassword(encryptedPwd);
        user.setSalt(salt);
        user.setCreateTime(now);

        Integer userId = createUser(user);

        SpringContextHolder.getApplicationContext().publishEvent(new UserCreateEvent(userId));

        return userId;
    }

    private Integer createUser(User user) {
        userDao.insertSelective(user);
        return user.getId();
    }

    @Override
    public void updateLoginInfo(Integer userId, String ip) {
        User user = new User();
        user.setId(userId);
        user.setLastLoginTime(new Date());
        user.setLastLoginIp(ip);
        userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<UserVo> queryUser(UserQueryParam param, PageBounds pb) {
        Preconditions.checkNotNull(param);
        Preconditions.checkNotNull(pb);

        return userExtDao.queryUser(param.getName(), pb);
    }
}
