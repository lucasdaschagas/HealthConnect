package com.healthApi.demo.exception.handler;

import com.healthApi.demo.exception.ProBoundNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ProBoundNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(ProBoundNotFoundException e, WebRequest wr) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), wr.getDescription(false), status.value());
        return ResponseEntity.status(status).body(exceptionResponse);
    }
}
