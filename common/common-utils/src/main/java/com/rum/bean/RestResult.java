package com.rum.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * 接口服务结果
 *
 * @author tjwang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestResult<T> implements Serializable {

    /**
     * 处理完成后的消息
     */
    public String         message = "";
    /**
     * 是否成功
     */
    private boolean       success;
    /**
     * 处理结果代码
     */
    private int           status;

    /**
     * 单个值
     */
    private T             data;

    /**
     * 多个值
     */
    private List<T>       dataList;

    /**
     * 带分页值
     */
    private PageResult<T> pageResult;

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

    public static <T> RestResult ok(T data) {
        RestResult result = new RestResult();
        result.setData(data);
        return result;
    }

    public static <T> RestResult<T> ok(List<T> data) {
        RestResult result = new RestResult();
        result.setDataList(data);
        return result;
    }

    public static <T> RestResult<T> ok(PageResult<T> data) {
        RestResult result = new RestResult();
        result.setPageResult(data);
        return result;
    }

    public static RestResult fail(int status, String message) {
        return new RestResult(status, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public PageResult<T> getPageResult() {
        return pageResult;
    }

    public void setPageResult(PageResult<T> pageResult) {
        this.pageResult = pageResult;
    }
}
