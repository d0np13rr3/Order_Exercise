package com.example.order_exercise.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException() {
        super("Item not found. Try an existing item.");
    }
}
