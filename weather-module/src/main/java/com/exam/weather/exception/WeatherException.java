package com.exam.weather.exception;

public class WeatherException extends Exception {

    private String msg;
    private Integer errorCode;

    public WeatherException(String msg, Integer errorCode) {
        this.msg = msg;
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
