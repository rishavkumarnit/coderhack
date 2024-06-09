package com.rishav.coderhack.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;



@ResponseStatus(value = HttpStatus.CONFLICT)
public class userAlreadyexists extends RuntimeException{
    
    public userAlreadyexists (String message){
        super(message);
    }

}