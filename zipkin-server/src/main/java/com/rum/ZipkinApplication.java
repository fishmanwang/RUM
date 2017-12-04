/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 *
 * @author tjwang
 * @version $Id: ZipkinApplication.java, v 0.1 2017/12/4 0004 10:34 tjwang Exp $
 */
@EnableZipkinServer
@SpringBootApplication
public class ZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }
}
