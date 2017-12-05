/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.bean;

/**
 * 包含数据的服务返回结果
 * 
 * @author tjwang
 * @version $Id: RestDataResult.java, v 0.1 2017/12/5 0005 14:04 tjwang Exp $
 */
public class RestDataResult<T> extends RestResult {

    private T data;

    public static <T> RestDataResult<T> ok(T data) {
        RestDataResult result = new RestDataResult();
        result.setData(data);
        return result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
