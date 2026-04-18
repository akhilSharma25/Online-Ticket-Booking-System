package com.learning.exception;

import java.time.LocalDateTime;

public class ErrorMsg {
    private  String statusCode;
    private  String mssg;
    private LocalDateTime localDateTime;

    public ErrorMsg() {
    }

    public ErrorMsg(String statusCode, String mssg, LocalDateTime localDateTime) {
        this.statusCode = statusCode;
        this.mssg = mssg;
        this.localDateTime = localDateTime;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMssg() {
        return mssg;
    }

    public void setMssg(String mssg) {
        this.mssg = mssg;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
