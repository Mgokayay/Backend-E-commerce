package com.workintech.backend.factory;


import com.workintech.backend.exceptions.CategoryException;
import org.springframework.http.HttpStatus;

public class CategoryIdChecker {

    public static void idChecker(Long id){
        if(id<0){
            throw new CategoryException("Id cannot be less than zero " + id, HttpStatus.BAD_REQUEST);
        }

    }
}
