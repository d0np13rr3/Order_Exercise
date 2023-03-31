package com.example.order_exercise.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NoItemInOrderException extends RuntimeException{
    public NoItemInOrderException() {
        super("Order is empty, place items in order before saving.");
    }
}
