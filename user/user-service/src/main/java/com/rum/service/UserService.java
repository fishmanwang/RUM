/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.service;

import com.mybatis.domain.PageBounds;
import com.rum.facade.param.UserQueryParam;
import com.rum.facade.param.UserRegisterParam;
import com.rum.facade.vo.UserVo;

import java.util.List;

/**
 * 用户服务
 * @author tjwang
 * @version $Id: UserService.java, v 0.1 2017/8/4 0004 16:01 tjwang Exp $
 */
public interface UserService {

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
    List<UserVo> queryUser(UserQueryParam param, PageBounds pb);

}
