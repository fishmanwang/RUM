/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.integration;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tjwang
 * @version $Id: TestService.java, v 0.1 2017/12/6 0006 10:47 tjwang Exp $
 */
@FeignClient(value = "test", fallback = TestServiceFallback.class)
public interface TestService {

    @RequestMapping("/test/do")
    String test();

}
