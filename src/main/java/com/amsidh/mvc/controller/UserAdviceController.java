package com.amsidh.mvc.controller;

import com.amsidh.mvc.controller.response.GenericResponse;
import com.amsidh.mvc.error.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class UserAdviceController {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleConstraintViolation(ConstraintViolationException ex) {
        log.debug("Constraint violation exception encountered: {}", ex.getConstraintViolations(), ex);
        List<ErrorDetails> errorDetailsList = ex.getConstraintViolations().stream().map(this::buildErrorDetails).collect(Collectors.toList());
        return new ResponseEntity(GenericResponse.builder().errorDetails(errorDetailsList).build(), HttpStatus.OK);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<ErrorDetails> errorDetailsList = bindingResult.getFieldErrors().stream().map(fieldError -> {
            return ErrorDetails.builder().fieldName(fieldError.getField()).code("1002").message(fieldError.getDefaultMessage()).build();
        }).collect(Collectors.toList());

        return new ResponseEntity(GenericResponse.builder().errorDetails(errorDetailsList).build(), HttpStatus.OK);

    }

    private ErrorDetails buildErrorDetails(ConstraintViolation violation) {
        String fieldName = (violation.getPropertyPath().toString().indexOf(".") >= 1) ? violation.getPropertyPath().toString().substring(violation.getPropertyPath().toString().lastIndexOf(".") + 1) : violation.getPropertyPath().toString();
        return ErrorDetails.builder()
                .fieldName(fieldName)
                .code("1001")
                .message(violation.getMessageTemplate())
                .build();
    }
}
