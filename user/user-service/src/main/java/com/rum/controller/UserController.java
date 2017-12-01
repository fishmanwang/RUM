/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.controller;

import com.mybatis.domain.PageBounds;
import com.mybatis.domain.Paginator;
import com.mybatis.util.PageListHelper;
import com.rum.bean.RestResult;
import com.rum.facade.UserFacade;
import com.rum.facade.param.UserQueryParam;
import com.rum.facade.vo.UserView;
import com.rum.service.UserService;
import com.rum.service.vo.UserVo;
import com.rum.util.BeanMapperUtil;
import com.rum.utils.PageBoundsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tjwang
 * @version $Id: UserController.java, v 0.1 2017/9/6 0006 10:00 tjwang Exp $
 */
@RestController
public class UserController implements UserFacade {

    @Autowired
    private UserService userService;

    @Override
    public RestResult<UserView> queryUsers(@RequestBody(required = true) UserQueryParam param) {
        PageBounds pb = PageBoundsHelper.create(param);
        List<UserVo> ds = userService.queryUser(param, pb);
        Paginator p = PageListHelper.getPaginator(ds);
        List<UserView> rs = BeanMapperUtil.mapList(ds, UserView.class);

        return RestResult.ok(PageListHelper.createPageResult(rs, p));
    }

    @Override
    public RestResult deleteUser(Integer userId) {
        userService.deleteUser(userId);
        return RestResult.ok();
    }

}
