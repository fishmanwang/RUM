/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.service;

import com.github.pagehelper.PageHelper;
import com.rum.dao.UserDao;
import com.rum.model.User;
import com.rum.model.UserExample;
import com.rum.service.vo.UserListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<UserListVO> queryUsers() {
        PageHelper.startPage(1, 2);
        List<User> users = userDao.selectByExample(new UserExample());
        return users.stream().map(user -> {
            UserListVO vo = new UserListVO();
            BeanUtils.copyProperties(user, vo);
            return vo;
        }).collect(Collectors.toList());
    }
}
