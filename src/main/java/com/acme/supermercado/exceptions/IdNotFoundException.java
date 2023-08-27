package com.acme.supermercado.exceptions;

public class IdNotFoundException extends RuntimeException {
    private String message;

    IdNotFoundException(){}

    public IdNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
