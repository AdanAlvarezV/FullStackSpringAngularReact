package com.example.demo.fullstack.DemoFullStack.common.util;

import com.example.demo.fullstack.DemoFullStack.common.exception.ErrorMessages;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class ErrorMessagesUtil {

    public static String formatMEssageError(BindingResult result){
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return  error;
                }).collect(Collectors.toList());
        ErrorMessages errorMessages = ErrorMessages.builder()
                .code(HttpStatus.BAD_REQUEST)
                .messages(errors)
                .date(new Date()).build();
        return formatObjectToJsonString(errorMessages);
    }

    public static String formatObjectToJsonString(Object object){
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(object);
        } catch (JsonProcessingException ex){
            log.error(Utils.stackTraceToString(ex));
        }
        return jsonString;
    }

    public static ResponseEntity<?> validar(BindingResult result){
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach((err) -> {
            //errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
            errores.put(err.getField(), err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
    /*
    public static Map<String, Object> validar(BindingResult result){
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach((err) -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        //return ResponseEntity.badRequest().body(errores);
        return errores;
    }*/
}
