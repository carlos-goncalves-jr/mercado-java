package com.acme.supermercado.exceptions;

public class DuplicateCategoriaException extends RuntimeException {
    private String message;
    public DuplicateCategoriaException(String message) {
        super(message);
        this.message = message;
    }

}
