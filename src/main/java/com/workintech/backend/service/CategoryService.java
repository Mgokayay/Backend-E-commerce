package com.workintech.backend.service;

import com.workintech.backend.dto.CategoryResponse;
import com.workintech.backend.entity.Category;

import java.util.List;

public interface CategoryService {

    CategoryResponse save(Category category);

   List<CategoryResponse> findAll();

    CategoryResponse findById(Long id);

    CategoryResponse delete(Long id);

    Category findByCategoryId(Long id);


}
