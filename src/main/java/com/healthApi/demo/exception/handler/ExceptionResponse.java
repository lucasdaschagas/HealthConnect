package com.healthApi.demo.exception.handler;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
    private Integer Status;



    public ExceptionResponse() {
    }


    public ExceptionResponse(Date timestamp, String message, String details, Integer status) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        Status = status;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public Integer getStatus() {
        return Status;
    }
}
