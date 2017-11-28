/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.facade;

import com.mybatis.domain.PageBounds;
import com.rum.facade.param.UserQueryParam;
import com.rum.facade.param.UserRegisterParam;
import com.rum.facade.vo.UserVo;

import java.util.List;

/**
 *
 * @author tjwang
 * @version $Id: UserFacade.java, v 0.1 2017/11/28 0028 17:13 tjwang Exp $
 */
public interface UserFacade {

    /**
     * 修改用户密码
     * @param userId
     * @param oldPwd
     * @param newPwd
     * @param newPwdConfirm
     */
    void modifyPassword(Integer userId, String oldPwd, String newPwd, String newPwdConfirm);

    /**
     * 管理员重置密码
     * @param userId
     * @param salt
     * @param newPwd
     * @param newPwdConfirm
     * @param administratorId
     */
    void adminResetPassword(Integer userId, String salt, String newPwd, String newPwdConfirm, String administratorId);

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    UserVo findUserByUsername(String username);

    /**
     * 删除用户
     *
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 注册用户
     * @param param
     * @return
     */
    Integer registerUser(UserRegisterParam param);

    /**
     * 更新登录信息
     * @param userId
     * @param ip
     */
    void updateLoginInfo(Integer userId, String ip);

    /**
     * 管理端查询用户
     *
     * @param param
     * @param pb
     * @return
     */
    List<UserVo> queryUserUser(UserQueryParam param, PageBounds pb);

}
