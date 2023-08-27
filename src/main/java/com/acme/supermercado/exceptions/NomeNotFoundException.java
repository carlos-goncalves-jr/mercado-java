package com.acme.supermercado.exceptions;

public class NomeNotFoundException extends RuntimeException {
    private String message;

    public NomeNotFoundException() {}
    public NomeNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
