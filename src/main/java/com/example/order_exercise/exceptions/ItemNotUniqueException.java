package com.example.order_exercise.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ItemNotUniqueException extends RuntimeException{

    public ItemNotUniqueException() {
        super("Item not unique. Item already exists.");
    }
}
