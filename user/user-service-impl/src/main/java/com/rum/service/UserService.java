/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.service;

import com.rum.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tjwang
 * @version $Id: UserService.java, v 0.1 2017/9/25 0025 14:49 tjwang Exp $
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 查询用户列表
     * @return
     */
    //    public PageInfo<UserListVO> queryUsers() {
    //        PageHelper.startPage(2, 2);
    //        Page<User> userPage = (Page<User>) userDao.selectByExample(new UserExample());
    //        return PageInfoHelper.create(userPage, UserListVO.class);
    //    }
}
