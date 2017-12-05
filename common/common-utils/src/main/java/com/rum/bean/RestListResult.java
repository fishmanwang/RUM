/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.bean;

import java.util.List;

/**
 * 包含数据列表的服务返回结果
 *
 * @author tjwang
 * @version $Id: RestListResult.java, v 0.1 2017/12/5 0005 14:00 tjwang Exp $
 */
public class RestListResult<T> extends RestResult {

    private List<T> data;

    public static <T> RestListResult<T> ok(List<T> data) {
        RestListResult result = new RestListResult();
        result.setData(data);
        return result;
    }

    public static <T> RestListResult<T> empty(int status, String message) {
        RestListResult<T> result = new RestListResult<>();
        result.setSuccess(false);
        result.setStatus(status);
        result.setMessage(message);
        return result;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
