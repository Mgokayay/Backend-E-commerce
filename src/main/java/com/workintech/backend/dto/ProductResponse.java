package com.workintech.backend.dto;

public record ProductResponse(Long id,String name,Double price,Long sellCount,Long stock,String description,String images,Long categoryId,Long storeId) {
}
