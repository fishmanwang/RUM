/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum;

import com.mybatis.pagination.OffsetLimitInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Mysql分页插件
 *
 * @author tjwang
 * @version $Id: PageListConfig.java, v 0.1 2017/11/29 0029 11:16 tjwang Exp $
 */
@Component
public class PageListConfig {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void init() {
        OffsetLimitInterceptor offsetLimitInterceptor = new OffsetLimitInterceptor();
        offsetLimitInterceptor.setDialectClass("com.mybatis.dialect.MySQLDialect");
        sqlSessionFactory.getConfiguration().addInterceptor(offsetLimitInterceptor);
    }

}
