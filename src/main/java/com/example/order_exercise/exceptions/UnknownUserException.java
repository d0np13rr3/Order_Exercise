package com.example.order_exercise.exceptions;

public class UnknownUserException extends RuntimeException{
    public UnknownUserException() {
        super("Unknown user. Please login.");
    }
}
