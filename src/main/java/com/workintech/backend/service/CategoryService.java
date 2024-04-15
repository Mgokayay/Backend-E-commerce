package com.workintech.backend.service;

import com.workintech.backend.entity.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

   List<Category> findAll();

    Category findById(Long id);

    Category delete(Long id);
}
