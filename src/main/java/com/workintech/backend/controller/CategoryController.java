package com.workintech.backend.controller;

import com.workintech.backend.dto.CategoryResponse;
import com.workintech.backend.entity.Category;
import com.workintech.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/")
    public List<CategoryResponse> findAll(){
       return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryResponse findById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @PostMapping
    public CategoryResponse save(@Validated @RequestBody Category category){
        return categoryService.save(category);

    }

    @DeleteMapping("/{id}")
    public CategoryResponse delete(@PathVariable Long id){
        return categoryService.delete(id);
    }
}
