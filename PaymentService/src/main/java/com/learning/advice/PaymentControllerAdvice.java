package com.learning.advice;

import com.learning.Exception.PaymentFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class PaymentControllerAdvice {

    @ExceptionHandler(PaymentFailedException.class)
    public ResponseEntity<ErrorMsg> handleTouristException(PaymentFailedException e){

        ErrorMsg errorDetail =new ErrorMsg("Resource missing",e.getMessage(), LocalDateTime.now());
        return  new ResponseEntity<ErrorMsg>(errorDetail, HttpStatus.PAYMENT_REQUIRED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMsg> handleException(Exception e){

        ErrorMsg errorDetail =new ErrorMsg("Internal Server Error",e.getMessage(), LocalDateTime.now());
        return  new ResponseEntity<ErrorMsg>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
