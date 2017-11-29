/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.facade.param;

import com.rum.bean.PageInfo;

/**
 * @author tjwang
 * @version $Id: UserQueryParam.java, v 0.1 2017/9/6 0006 10:19 tjwang Exp $
 */
public class UserQueryParam extends PageInfo {

    private String name;

    public UserQueryParam() {

    }

    public UserQueryParam(PageInfo pageInfo) {
        setPage(pageInfo.getPage());
        setLimit(pageInfo.getLimit());
        setOrder(pageInfo.getOrder());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
