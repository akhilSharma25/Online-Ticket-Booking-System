package com.learning.advice;

import com.learning.Exception.TicketNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TicketControllerAdvice {

    @ExceptionHandler(TicketNotFoundException.class)
    public ResponseEntity<ErrorMsg> handleTouristException(TicketNotFoundException e){

        ErrorMsg errorDetail =new ErrorMsg("404 not found",e.getMessage(), LocalDateTime.now());
        return  new ResponseEntity<ErrorMsg>(errorDetail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMsg> handleException(Exception e){

        ErrorMsg errorDetail =new ErrorMsg("Internal Server Error",e.getMessage(), LocalDateTime.now());
        return  new ResponseEntity<ErrorMsg>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
