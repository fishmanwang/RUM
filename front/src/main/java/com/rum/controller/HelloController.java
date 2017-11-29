/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.controller;

import com.rum.bean.RestResult;
import com.rum.facade.param.UserQueryParam;
import com.rum.integration.UserFacadeRefactor;
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

    private Logger             logger = LoggerFactory.getLogger(getClass());

    //    @Autowired
    //    private DiscoveryClient client;

    @Autowired
    private UserFacadeRefactor userFacade;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String index() {
        //        logger.info(client.getAllKnownRegions().toString());
        return "Hello Spring Cloud";
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public RestResult sayHello(@PathVariable("name") String name) {
        UserQueryParam param = new UserQueryParam(getPageInfo());
        param.setName(name);
        RestResult result = userFacade.queryUsers(param);
        return result;
    }
}
