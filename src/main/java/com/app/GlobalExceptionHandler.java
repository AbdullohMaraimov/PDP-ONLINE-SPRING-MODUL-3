package com.app;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(TodoNotFoundException.class)
//    public ResponseEntity<ErrorDTO> handleException(TodoNotFoundException e, HttpServletRequest req) {
//        return ResponseEntity.status(404)
//                .body(ErrorDTO.builder()
//                        .errorPath(req.getRequestURI())
//                        .errorCode(404)
//                        .errorBody(e.getMessage())
//                        .build()
//                );
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleException(MethodArgumentNotValidException e, HttpServletRequest req) {

        Map<String, String> errorBody = new HashMap<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            String field = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            errorBody.put(field, defaultMessage);
        }


        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
                .body(ErrorDTO.builder()
                        .errorPath(req.getRequestURI())
                        .errorCode(HttpStatus.BAD_REQUEST.value())
                        .errorBody(errorBody)
                        .build()
                );
    }

}
