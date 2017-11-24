/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author tjwang
 * @version $Id: Application.java, v 0.1 2017/11/24 0024 14:57 tjwang Exp $
 */
@SpringBootApplication
@MapperScan("com.rum.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
