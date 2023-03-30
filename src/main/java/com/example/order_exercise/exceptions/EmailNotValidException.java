package com.example.order_exercise.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmailNotValidException extends RuntimeException {


    public EmailNotValidException() {
        super("Given email is not valid.");
    }
}
