package com.sample.server.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {

    private int code;

    private String message;
    private String exception;

    private Integer appCode;

    private ErrorMessage(int code, String message, String exception, Integer appCode) {
        this.code = code;
        this.message = message;
        this.exception = exception;
        this.appCode = appCode;
    }

    public static ErrorMessage of(int code, String message, String exception, Integer appCode) {
        return new ErrorMessage(code, message, exception, appCode);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Integer getAppCode() {
        return appCode;
    }

    public void setAppCode(Integer appCode) {
        this.appCode = appCode;
    }
}
