/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.bean;

import java.util.List;

/**
 * 分页结果返回
 * 
 * @author tjwang
 * @version $Id: PageResult.java, v 0.1 2017/12/1 0001 10:22 tjwang Exp $
 */
public class PageResult<T> {

    /**
     * 分页大小
     */
    private int     limit;
    /**
     * 页数
     */
    private int     page;
    /**
     * 总记录数
     */
    private int     totalCount;

    private List<T> data;

    public PageResult() {
        page = 1;
        limit = 10;
        totalCount = 0;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
