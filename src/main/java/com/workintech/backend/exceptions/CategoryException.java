package com.workintech.backend.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CategoryException extends RuntimeException{

    private HttpStatus httpStatus;

    public CategoryException (String message,HttpStatus httpStatus){
        super(message);
        this.httpStatus=httpStatus;
    }
}
