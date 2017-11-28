/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.service;

import com.mybatis.domain.PageList;
import com.rum.service.vo.UserListVO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserService测试
 * @author tjwang
 * @version $Id: UserServiceTest.java, v 0.1 2017/11/24 0024 16:16 tjwang Exp $
 */
public class UserServiceTest extends BaseServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testQueryUser() {
        PageList<UserListVO> users = userService.queryUsers();
        Assert.assertTrue(users.size() != 0);
    }
}
