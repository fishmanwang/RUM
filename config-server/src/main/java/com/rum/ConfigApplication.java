/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 *
 * @author tjwang
 * @version $Id: ConfigApplication.java, v 0.1 2017/12/4 0004 11:07 tjwang Exp $
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }

}
