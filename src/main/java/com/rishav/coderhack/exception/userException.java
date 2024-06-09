package com.rishav.coderhack.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;



@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class userException extends RuntimeException{
    
    public userException (String message){
        super(message);
    }

}
