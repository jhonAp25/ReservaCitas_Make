package com.apaza.citas.config.exception;

public class BadRequest  extends RuntimeException{
    public BadRequest(String message) {
        super(message);
    }
}
