package com.genesis.demo.exceptions;

import com.genesis.demo.models.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response> notFoundExceptionHandle(NotFoundException notFoundException){
        return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .message(List.of(notFoundException.getMessage()))
                        .statusCode(HttpStatus.NOT_FOUND.toString())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<Response> alreadyExistsExceptionHandle(AlreadyExistsException alreadyExistsException){
        return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .message(List.of(alreadyExistsException.getMessage()))
                        .statusCode(HttpStatus.CONFLICT.toString())
                        .build(),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.add(fieldName.concat(" "+errorMessage));
        });
        return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .message(errors)
                        .statusCode(HttpStatus.BAD_REQUEST.toString())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }
}
