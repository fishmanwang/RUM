/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.service;

import com.mybatis.domain.PageBounds;
import com.mybatis.domain.PageList;
import com.mybatis.util.PageListHelper;
import com.rum.dao.UserDao;
import com.rum.model.User;
import com.rum.model.UserExample;
import com.rum.service.vo.UserListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public PageList<UserListVO> queryUsers() {
        PageBounds pb = new PageBounds(2, 2);
        List<User> users = userDao.selectByExampleWithPageBounds(new UserExample(), pb);
        return PageListHelper.create(users, UserListVO.class);
    }
}
