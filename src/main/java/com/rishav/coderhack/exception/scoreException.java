package com.rishav.coderhack.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;



@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class scoreException extends RuntimeException{
    
    public scoreException (String message){
        super(message);
    }

}