package com.workintech.backend.dto;

import com.workintech.backend.entity.Product;
import com.workintech.backend.enums.Gender;

import java.util.List;

public record CategoryResponse(Long id, String code, Gender gender, String img, Double rating, String title,
                               List<Product> productResponse) {
}
