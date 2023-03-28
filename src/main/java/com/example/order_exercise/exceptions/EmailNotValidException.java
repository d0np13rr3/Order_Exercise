package com.example.order_exercise.exceptions;

public class EmailNotValidException extends RuntimeException {
    public EmailNotValidException() {
        super("Given email is not valid.");
    }
}
