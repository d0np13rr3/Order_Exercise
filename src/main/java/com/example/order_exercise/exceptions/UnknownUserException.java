package com.example.order_exercise.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnknownUserException extends RuntimeException{
    public UnknownUserException() {
        super("Unknown user. Please login or retry with valid credentials.");
    }
}
