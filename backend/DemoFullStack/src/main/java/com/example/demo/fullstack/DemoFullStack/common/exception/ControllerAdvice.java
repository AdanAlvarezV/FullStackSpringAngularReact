package com.example.demo.fullstack.DemoFullStack.common.exception;

import com.example.demo.fullstack.DemoFullStack.common.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorDTO> businessExceptionHandler(BusinessException ex){
        ErrorDTO error = ErrorDTO.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .date(ex.getDate()).build();
        log.error(Utils.stackTraceToString(ex));
        return new ResponseEntity<>(error, ex.getCode());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDTO> runtimeExceptionHandler(BusinessException ex){
        ErrorDTO error = ErrorDTO.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .date(ex.getDate()).build();
        log.error(Utils.stackTraceToString(ex));
        return new ResponseEntity<>(error, ex.getCode());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorDTO> exceptionHandler(Exception ex){
        ErrorDTO error = ErrorDTO.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(ex.getMessage())
                .date(new Date()).build();
        log.error(Utils.stackTraceToString(ex));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
