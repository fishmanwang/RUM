/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.bean;

/**
 * 分页信息 - 用户接收用户分页参数
 * @author tjwang
 * @version $Id: PageInfo.java, v 0.1 2017/11/29 0029 11:31 tjwang Exp $
 */
public class PageInfo {

    /** 页号 */
    private int    page  = 1;

    /** 分页大小 */
    private int    limit = Integer.MAX_VALUE;

    /**
     * 排序 : column:[asc|desc],column:[asc|desc]
     */
    private String order;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
