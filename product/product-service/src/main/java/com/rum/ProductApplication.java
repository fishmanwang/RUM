/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 *
 * @author tjwang
 * @version $Id: ProductApplication.java, v 0.1 2017/12/6 0006 15:17 tjwang Exp $
 */
@SpringBootApplication
@EnableConfigurationProperties
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class);
    }

}
