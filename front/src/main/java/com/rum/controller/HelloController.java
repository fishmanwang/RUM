/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tjwang
 * @version $Id: HelloController.java, v 0.1 2017/11/22 0022 11:13 tjwang Exp $
 */
@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //    @Autowired
    //    private DiscoveryClient client;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String index() {
        //        logger.info(client.getAllKnownRegions().toString());
        return "Hello Spring Cloud";
    }
}
