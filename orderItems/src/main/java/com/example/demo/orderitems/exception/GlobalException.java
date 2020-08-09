package com.example.demo.orderitems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.NoSuchElementException;

@ControllerAdvice
@RestController
public class GlobalException {
    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<ErrorDetails> handleNoSuchElementException() {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"ReasonCode Not Found");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
