/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.service;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试dao层的基础类
 *
 * @author tjwang
 * @version $Id: BaseDaoTest.java, v 0.1 2017/1/25 0025 17:29 tjwang Exp $
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BaseServiceTest extends Assert {

    protected Logger logger = LoggerFactory.getLogger(getClass());

}
