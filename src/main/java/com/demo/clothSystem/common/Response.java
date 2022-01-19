package com.demo.clothSystem.common;

public class Response<T> {
    private int code;

    private String message;

    private T data;

    public static <T> Response<T> ok(T data) {
        Response<T> response = new Response<>();
        response.code = 200;
        response.data = data;
        return response;
    }

    public static Response<String> ok() {
        Response<String> response = new Response<>();
        response.code = 200;
        return response;
    }

    public static <T> Response<T> error(String message) {
        Response<T> response = new Response<>();
        response.code = 400;
        response.message = message;
        return response;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

