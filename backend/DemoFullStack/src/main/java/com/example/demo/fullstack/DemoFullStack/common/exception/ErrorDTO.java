package com.example.demo.fullstack.DemoFullStack.common.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@Builder
public class ErrorDTO {

    private HttpStatus code;
    private String message;
    private Date date;
}
