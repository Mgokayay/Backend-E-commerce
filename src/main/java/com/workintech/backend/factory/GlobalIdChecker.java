package com.workintech.backend.factory;


import com.workintech.backend.exceptions.CommonException;
import org.springframework.http.HttpStatus;

public class GlobalIdChecker {

    public static void categoryIdChecker(Long id){
        if(id<0){
            throw new CommonException("Id cannot be less than zero " + id, HttpStatus.BAD_REQUEST);
        }


    }
}
