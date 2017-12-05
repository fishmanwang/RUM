/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.util;

import com.rum.bean.*;

import java.util.List;

/**
 * 服务返回结果工具类
 * 
 * @author tjwang
 * @version $Id: RestResultUtil.java, v 0.1 2017/12/5 0005 15:02 tjwang Exp $
 */
public class RestResultUtil {

    public static RestResult buildRestResult() {
        return new RestResult();
    }

    public static RestResult buildFailRestResult(int status, String message) {
        return new RestResult(status, message);
    }

    public static <T> RestDataResult<T> buildRestDataResult(T data) {
        RestDataResult result = new RestDataResult();
        result.setData(data);
        return result;
    }

    public static <T> RestDataResult<T> buildFailRestDataResult(int status, String message) {
        RestDataResult result = new RestDataResult();
        buildFailResult(status, message, result);
        return result;
    }

    public static <T> RestListResult<T> buildRestListResult(List<T> data) {
        RestListResult result = new RestListResult();
        result.setData(data);
        return result;
    }

    public static <T> RestListResult<T> buildFailRestListResult(int status, String message) {
        RestListResult result = new RestListResult();
        buildFailResult(status, message, result);
        return result;
    }

    public static <T> RestPageResult buildRestPageResult(PageResult<T> data) {
        RestPageResult result = new RestPageResult();
        result.setData(data);
        return result;
    }

    public static <T> RestPageResult<T> buildFailRestPageResult(int status, String message) {
        RestPageResult result = new RestPageResult();
        buildFailResult(status, message, result);
        return result;
    }

    public static void buildFailResult(int status, String message, RestResult result) {
        result.setSuccess(false);
        result.setStatus(status);
        result.setMessage(message);
    }

}
