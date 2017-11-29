/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.facade;

import com.rum.bean.RestResult;
import com.rum.facade.param.UserQueryParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户服务访问门面
 * @author tjwang
 * @version $Id: UserFacade.java, v 0.1 2017/11/28 0028 17:13 tjwang Exp $
 */
@RequestMapping("/user")
public interface UserFacade {

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    RestResult queryUsers(@RequestBody UserQueryParam param);

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    RestResult deleteUser(@RequestParam("userId") Integer userId);

}
