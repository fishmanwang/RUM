package com.rum.exception;

/**
 * 系统异常，需统一对外描述为系统异常
 * 
 * Created by tjwang on 2017/2/22.
 */
public class SystemException extends RuntimeException {

    /**
     * 系统错误代码
     */
    private ErrorCode errorCode;

    public SystemException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public SystemException(ErrorCode errorCode, Throwable ex) {
        super(errorCode.getMessage(), ex);
        this.errorCode = errorCode;
    }

    public SystemException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public SystemException(ErrorCode errorCode, String message, Throwable ex) {
        super(message, ex);
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return errorCode.getMessage();
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
