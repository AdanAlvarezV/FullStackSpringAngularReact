package com.example.demo.fullstack.DemoFullStack.common.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class BusinessException extends RuntimeException{

    private HttpStatus code;
    private Date date;

    public BusinessException(String message, HttpStatus code) {
        super(message);
        this.code = code;
        this.date = new Date();
    }
}
