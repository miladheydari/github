package com.xapo.github.utils;



import retrofit2.Response;


public class GeneralApiException extends Exception {
    private String message;
    private int code;




    private final transient Response<?> response;


    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public GeneralApiException(Response<?> response) {
        this.response = response;
    }

    public int code() {
        return code;
    }


    public String message() {
        return message;
    }


    public Response<?> response() {
        return response;
    }

}
