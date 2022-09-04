package com.ozer.ftspringpracticum.core.utilities.exceptions;

public class CommentNotFoundException extends CustomException {

    public CommentNotFoundException() {
        super("Comment Not Found !!");
    }

    public CommentNotFoundException(String message) {
        super(message);
    }
}
