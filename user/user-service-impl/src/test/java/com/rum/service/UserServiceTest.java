/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.service;

import com.rum.service.vo.UserListVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 *
 * @author tjwang
 * @version $Id: UserServiceTest.java, v 0.1 2017/11/24 0024 16:16 tjwang Exp $
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testQueryUser() {
        List<UserListVO> users = userService.queryUsers();
        Assert.assertTrue(users.size() != 0);
    }
}
