package com.acme.supermercado.exceptions;

import lombok.*;

import java.util.Date;

@Data
public class ExceptionObject {
    private int statusCode;
    private String responseMessage;
    private Date timestamp;

    public ExceptionObject(){}

    public ExceptionObject(String responseMessage) {
        super();
        this.responseMessage = responseMessage;
    }

    public ExceptionObject(int statusCode, String responseMessage){
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
    }

}
