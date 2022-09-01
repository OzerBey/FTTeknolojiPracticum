package com.ozer.ftspringpracticum.core.utilities.exceptions;

public class CustomException extends Exception {
    private String message;

    public CustomException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
