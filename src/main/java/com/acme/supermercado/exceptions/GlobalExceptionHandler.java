package com.acme.supermercado.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ExceptionObject> handlerIdNotFoundException(IdNotFoundException ex, WebRequest request) {
        ExceptionObject exceptionResponse = new ExceptionObject();
        exceptionResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        exceptionResponse.setResponseMessage(ex.getMessage());
        exceptionResponse.setTimestamp(new Date());
        return new ResponseEntity<ExceptionObject>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NomeNotFoundException.class)
    public ResponseEntity<ExceptionObject> handlerNomeNotFoundException(NomeNotFoundException ex, WebRequest request) {
        ExceptionObject exceptionResponse = new ExceptionObject();
        exceptionResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        exceptionResponse.setResponseMessage(ex.getMessage());
        exceptionResponse.setTimestamp(new Date());
        return new ResponseEntity<ExceptionObject>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ExceptionObject> handlerDuplicateException(DuplicateException ex, WebRequest request) {
        ExceptionObject exceptionResponse = new ExceptionObject();
        exceptionResponse.setStatusCode(HttpStatus.CONFLICT.value());
        exceptionResponse.setResponseMessage(ex.getMessage());
        exceptionResponse.setTimestamp(new Date());
        return new ResponseEntity<ExceptionObject>(exceptionResponse, HttpStatus.CONFLICT);
    }
}
