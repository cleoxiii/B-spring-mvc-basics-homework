package com.thoughtworks.capacity.gtb.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException exception) {
        String message = Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResult(HttpStatus.BAD_REQUEST.value(), message));
    }

    @ExceptionHandler(UserIsExistedException.class)
    public ResponseEntity<ErrorResult> handle(UserIsExistedException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResult(HttpStatus.BAD_REQUEST.value(), exception.getMessage()));
    }
}
