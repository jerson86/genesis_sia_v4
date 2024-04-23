package com.genesis.demo.exceptions;

import com.genesis.demo.models.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@ControllerAdvice
@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundExceptionHandle(NotFoundException notFoundException){
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .date(LocalDate.now())
                        .message(notFoundException.getMessage())
                        .statusCode(HttpStatus.NOT_FOUND.toString())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> alreadyExistsExceptionHandle(AlreadyExistsException alreadyExistsException){
        return new ResponseEntity<ErrorResponse>(
                ErrorResponse.builder()
                        .date(LocalDate.now())
                        .message(alreadyExistsException.getMessage())
                        .statusCode(HttpStatus.CONFLICT.toString())
                        .build(),
                HttpStatus.CONFLICT
        );
    }
}
