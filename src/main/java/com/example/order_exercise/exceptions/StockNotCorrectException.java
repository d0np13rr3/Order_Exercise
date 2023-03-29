package com.example.order_exercise.exceptions;

public class StockNotCorrectException extends RuntimeException{

    public StockNotCorrectException() {
        super("You are ordering to much, make your wanted total smaller.");
    }
}
