package com.example.demo.fullstack.DemoFullStack.common.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class ErrorMessages {

    private HttpStatus code;
    private List<Map<String, String>> messages;
    private Date date;
}
