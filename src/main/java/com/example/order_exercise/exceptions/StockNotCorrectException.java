package com.example.order_exercise.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class StockNotCorrectException extends RuntimeException{

    public StockNotCorrectException() {
        super("You are ordering to much, make your wanted total smaller.");
    }
}
