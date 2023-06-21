package com.springprojects.automobileserver.controllers;

import com.springprojects.automobileserver.models.ErrorResponseModel;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
public class ExceptionControllers {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseModel handleValidationException(ConstraintViolationException ex) {
        return new ErrorResponseModel("Invalid Value", ex.getMessage());
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseModel handleArgumentTypeException(MethodArgumentTypeMismatchException ex) {
        return new ErrorResponseModel("Invalid Type", ex.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseModel handleNotReadableException(HttpMessageNotReadableException ex) {
        return new ErrorResponseModel("Invalid request", ex.getMessage());
    }
}
