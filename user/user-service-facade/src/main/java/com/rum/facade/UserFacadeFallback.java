/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.facade;

import com.rum.bean.RestDataResult;
import com.rum.bean.RestPageResult;
import com.rum.bean.RestResult;
import com.rum.facade.param.UserQueryParam;
import com.rum.facade.vo.UserView;
import com.rum.util.RestResultUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户门面降级访问接口
 * @author tjwang
 * @version $Id: UserFacadeFallback.java, v 0.1 2017/11/29 0029 14:24 tjwang Exp $
 */
public class UserFacadeFallback implements UserFacade {

    @Override
    public RestPageResult<UserView> queryUsers(@RequestBody UserQueryParam param) {
        return RestResultUtil.buildFailRestPageResult(101, "查询用户失败");
    }

    @Override
    public RestDataResult<String> hi() {
        return RestResultUtil.buildFailRestDataResult(102, "打招呼失败");
    }

    @Override
    public RestResult deleteUser(@RequestParam("userId") Integer userId) {
        return RestResult.fail(101, "删除用户失败");
    }
}
