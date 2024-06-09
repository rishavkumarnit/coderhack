package com.rishav.coderhack.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class exceptionHandler {

    @ExceptionHandler(userException.class)
    public ResponseEntity<String> handleuserInput(userException newuserexception){
        return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(scoreException.class)
    public ResponseEntity<String> handlescoreInput(scoreException newscoreexception){
        return new ResponseEntity<String>("Score between 0 and 100 is allowed", HttpStatus.BAD_REQUEST);
    }

}
