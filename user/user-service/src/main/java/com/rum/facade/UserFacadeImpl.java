/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.facade;

import com.rum.bean.PageInfo;
import com.rum.facade.param.UserQueryParam;
import com.rum.facade.param.UserRegisterParam;
import com.rum.facade.vo.UserVo;
import com.rum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户门面实现
 * @author tjwang
 * @version $Id: UserFacadeImpl.java, v 0.1 2017/11/29 0029 11:39 tjwang Exp $
 */
@Service
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Override
    public void modifyPassword(Integer userId, String oldPwd, String newPwd, String newPwdConfirm) {
        userService.modifyPassword(userId, oldPwd, newPwd, newPwdConfirm);
    }

    @Override
    public void adminResetPassword(Integer userId, String salt, String newPwd, String newPwdConfirm, String administratorId) {
        userService.adminResetPassword(userId, salt, newPwd, newPwdConfirm, administratorId);
    }

    @Override
    public void deleteUser(Integer userId) {
        userService.deleteUser(userId);
    }

    @Override
    public Integer registerUser(UserRegisterParam param) {
        return userService.registerUser(param);
    }

    @Override
    public void updateLoginInfo(Integer userId, String ip) {
        userService.updateLoginInfo(userId, ip);
    }

    @Override
    public List<UserVo> queryUserUser(UserQueryParam param, PageInfo pb) {

        return null;
    }
}
