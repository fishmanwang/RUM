/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.controller;

import com.mybatis.domain.Paginator;
import com.mybatis.util.PageListHelper;
import com.rum.bean.RestResult;
import com.rum.controller.vo.UserView;
import com.rum.dao.vo.UserVo;
import com.rum.facade.param.UserQueryParam;
import com.rum.service.UserService;
import com.rum.util.BeanMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tjwang
 * @version $Id: UserController.java, v 0.1 2017/9/6 0006 10:00 tjwang Exp $
 */
@RestController
@RequestMapping("/user")
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    @RequestMapping("/query")
    public RestResult queryUsers(UserQueryParam param) {
        List<UserVo> ds = userService.queryUser(param, getPageBounds());
        Paginator p = PageListHelper.getPaginator(ds);
        List<UserView> rs = BeanMapperUtil.mapList(ds, UserView.class);
        return RestResult.ok(PageListHelper.create(rs, p));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public RestResult deleteUser(Integer userId) {
        userService.deleteUser(userId);
        return RestResult.ok();
    }

}
