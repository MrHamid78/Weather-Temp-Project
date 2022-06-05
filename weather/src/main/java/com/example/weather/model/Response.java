package com.example.weather.model;

import java.util.List;

public class Response {
    private String status;
    private Integer statusCode;
    private Object data;

    public Response() {
        this.status = "ok";
        this.statusCode = 200;
        this.data = null;
    }
    public Response(Object data) {
        this.status = "ok";
        this.statusCode = 200;
        this.data = data;
    }
    public Response(String status, Integer statusCode) {
        this.status = status;
        this.statusCode = statusCode;
        this.data = null;
    }
    public Response(String status, Integer statusCode, Object data) {
        this.status = status;
        this.statusCode = statusCode;
        this.data = data;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
