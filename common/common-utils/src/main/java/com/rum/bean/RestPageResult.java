/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.bean;

/**
 * 包含分页信息的服务返回结果
 * 
 * @author tjwang
 * @version $Id: RestPageResult.java, v 0.1 2017/12/5 0005 14:01 tjwang Exp $
 */
public class RestPageResult<T> extends RestResult {

    private PageResult<T> data;

    public static <T> RestPageResult<T> ok(PageResult<T> data) {
        RestPageResult result = new RestPageResult();
        result.setData(data);
        return result;
    }

    public static <T> RestPageResult<T> empty(int status, String message) {
        RestPageResult<T> result = new RestPageResult<>();
        result.setSuccess(false);
        result.setStatus(status);
        result.setMessage(message);
        return result;
    }

    public PageResult<T> getData() {
        return data;
    }

    public void setData(PageResult<T> data) {
        this.data = data;
    }
}
