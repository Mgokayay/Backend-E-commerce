package com.workintech.backend.exceptions;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryErrorResponse {
       private Integer status;
       private String message;
       private LocalDateTime timeStamp;


}
