/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.bean;

/**
 * 服务返回基础结果
 * 
 * @author tjwang
 * @version $Id: RestResult.java, v 0.1 2017/12/5 0005 13:59 tjwang Exp $
 */
public class RestResult {

    /**
     * 处理完成后的消息
     */
    public String   message = "";
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 处理结果代码
     */
    private int     status;

    public RestResult() {
        this.success = true;
        this.message = "ok";
    }

    public RestResult(int status, String message) {
        this.success = false;
        this.status = status;
        this.message = message;
    }

    public static RestResult ok() {
        return new RestResult();
    }

    public static RestResult fail(int status, String message) {
        return new RestResult(status, message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
