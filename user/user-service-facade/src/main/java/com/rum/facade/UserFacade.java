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
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户服务访问门面
 * @author tjwang
 * @version $Id: UserFacade.java, v 0.1 2017/11/28 0028 17:13 tjwang Exp $
 */
@FeignClient(value = "user", fallback = UserFacadeFallback.class)
public interface UserFacade {

    @RequestMapping(value = "/user/query", method = RequestMethod.POST)
    RestPageResult<UserView> queryUsers(@RequestBody UserQueryParam param);

    @RequestMapping(value = "/user/hi", method = RequestMethod.GET)
    RestDataResult<String> hi();

    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    RestResult deleteUser(@RequestParam("userId") Integer userId);

}
