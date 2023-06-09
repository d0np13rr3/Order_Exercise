package com.example.order_exercise.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MemberNotUniqueException extends RuntimeException{

    public MemberNotUniqueException() {
        super("Email not unique. Member already exists.");
    }
}
