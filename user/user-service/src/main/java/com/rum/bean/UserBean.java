/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author tjwang
 * @version $Id: UserBean.java, v 0.1 2017/12/4 0004 14:25 tjwang Exp $
 */
@Component
@ConfigurationProperties
public class UserBean {

    private String foo;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }
}
