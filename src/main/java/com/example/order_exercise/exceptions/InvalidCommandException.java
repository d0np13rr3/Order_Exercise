package com.example.order_exercise.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidCommandException extends RuntimeException{
    public InvalidCommandException() {

        super("Invalid command, try something you are allowed to do.");
    }
}
