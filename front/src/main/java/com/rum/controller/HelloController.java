/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.controller;

import com.rum.bean.RestDataResult;
import com.rum.bean.RestPageResult;
import com.rum.facade.UserFacade;
import com.rum.facade.param.UserQueryParam;
import com.rum.facade.vo.UserView;
import com.rum.integration.TestService;
import com.rum.util.RestResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tjwang
 * @version $Id: HelloController.java, v 0.1 2017/11/22 0022 11:13 tjwang Exp $
 */
@RestController
public class HelloController extends AbstractController {

    private Logger      logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserFacade  userFacade;

    @Autowired
    private TestService testService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public RestDataResult<String> index() {
        //        logger.info(client.getAllKnownRegions().toString());
        return userFacade.hi();
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public RestPageResult sayHello(@PathVariable("name") String name) {
        UserQueryParam param = new UserQueryParam(getPageInfo());
        param.setName(name);
        RestPageResult<UserView> result = userFacade.queryUsers(param);
        return result;
    }

    @RequestMapping(value = "/hello/test", method = RequestMethod.GET)
    public RestDataResult<String> helloTest() {
        return RestResultUtil.buildRestDataResult(testService.test());
    }
}
