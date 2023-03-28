package com.example.order_exercise.exceptions;

public class MemberNotUniqueException extends RuntimeException{

    public MemberNotUniqueException() {
        super("Email not unique. Member already exists.");
    }
}
