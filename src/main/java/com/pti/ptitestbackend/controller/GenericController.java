package com.pti.ptitestbackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class GenericController {

    public ResponseEntity<Object> success(Object o){
        return ResponseEntity.ok().body(o);
    }

    public ResponseEntity<HashMap<String, String>> badRequest(Exception e) {
        HashMap<String, String> res = new HashMap<>();
        log.error(e.getMessage(), e);
        res.put("error", "Error al processar la peticion");
        res.put("detail", e.getMessage());
        return ResponseEntity.badRequest().body(res);
    }

    public ResponseEntity<HashMap<String, Object>> deleteRequest(){
        HashMap<String, Object> res = new HashMap<>();
        res.put("status", HttpStatus.OK);
        res.put("message", "Removido exitosamente");
        return ResponseEntity.badRequest().body(res);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}