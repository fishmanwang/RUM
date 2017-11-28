/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        //        PageInfo<UserListVO> pageInfo = userService.queryUsers();
        //        Assert.assertTrue(pageInfo.getList().size() != 0);
    }
}
