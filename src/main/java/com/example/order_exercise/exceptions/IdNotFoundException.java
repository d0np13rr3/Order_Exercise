package com.example.order_exercise.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException() {
        super("Id not found. Try an existing id.");
    }
}
