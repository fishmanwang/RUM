/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.integration;

import org.springframework.stereotype.Component;

/**
 *
 * @author tjwang
 * @version $Id: TestServiceFallback.java, v 0.1 2017/12/6 0006 10:48 tjwang Exp $
 */
@Component
public class TestServiceFallback implements TestService {

    @Override
    public String test() {
        return "Sorry, nothing to to.";
    }
}
