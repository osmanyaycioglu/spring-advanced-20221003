package com.training.spring.advanced.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(IllegalArgumentException exception) {
        return ErrorObj.createBaseErrorObj()
                       .setErrorDesc(exception.getMessage())
                       .setErrorCode(1024);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(MethodArgumentNotValidException exception) {
        System.out.println("All Errors : " + exception.getAllErrors());
        return ErrorObj.createBaseErrorObj()
                       .setErrorDesc("Validasyon problemi")
                       .setErrorCode(2024)
                       .addMultipleSubErrors(exception.getAllErrors()
                                                      .stream()
                                                      .peek(System.out::println)
                                                      .map(oe -> ErrorObj.createBaseErrorObj()
                                                                         .setErrorDesc(oe.toString())
                                                                         .setErrorCode(1011))
                                                      .collect(Collectors.toList()));

    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(ConstraintViolationException exception) {
        return ErrorObj.createBaseErrorObj()
                       .setErrorDesc("Validasyon problemi")
                       .setErrorCode(2025)
                       .addMultipleSubErrors(exception.getConstraintViolations()
                                                      .stream()
                                                      .map(oe -> ErrorObj.createBaseErrorObj()
                                                                         .setErrorDesc(oe.toString())
                                                                         .setErrorCode(1011))
                                                      .collect(Collectors.toList()));

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handle(Exception exception) {
        exception.printStackTrace();
        if (exception instanceof NullPointerException) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                                 .header("xyz",
                                         "deneme")
                                 .body(ErrorObj.createBaseErrorObj()
                                               .setErrorDesc(exception.getMessage())
                                               .setErrorCode(1024));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .header("xyz",
                                     "deneme")
                             .body(ErrorObj.createBaseErrorObj()
                                           .setErrorDesc(exception.getMessage())
                                           .setErrorCode(1024));
    }

}
