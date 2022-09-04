package com.ozer.ftspringpracticum.core.utilities.exceptions;

public class ProductNotFoundException extends CustomException {

    public ProductNotFoundException() {
        super("Product Not Found !!");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
