/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *
 * @author tjwang
 * @version $Id: Application.java, v 0.1 2017/12/1 0001 11:17 tjwang Exp $
 */
@EnableZuulProxy
@SpringCloudApplication
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
