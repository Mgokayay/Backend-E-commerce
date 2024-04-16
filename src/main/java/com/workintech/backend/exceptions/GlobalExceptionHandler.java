package com.workintech.backend.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryException.class)
    public ResponseEntity<CategoryErrorResponse> handleException(CategoryException categoryException){
        log.error("CategoryException occured ! Exception details : " + categoryException.getMessage());

        CategoryErrorResponse categoryErrorResponse = new CategoryErrorResponse(categoryException.getHttpStatus().value(),
                categoryException.getMessage(),
                LocalDateTime.now());

        return new ResponseEntity<>(categoryErrorResponse,categoryException.getHttpStatus());
    }

    public ResponseEntity<CategoryErrorResponse> handleException(Exception exception){
        log.error("GeneralException occured ! Exception details : " + exception.getMessage());

        CategoryErrorResponse categoryErrorResponse = new CategoryErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(),LocalDateTime.now());

        return new ResponseEntity<>(categoryErrorResponse , HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
