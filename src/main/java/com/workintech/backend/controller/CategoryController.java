package com.workintech.backend.controller;

import com.workintech.backend.entity.Category;
import com.workintech.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/")
    public List<Category> findAll(){
       return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @PostMapping
    public Category save(@RequestBody Category category){
        return categoryService.save(category);

    }

    @DeleteMapping("/{id}")
    public Category delete(@PathVariable Long id){
        return categoryService.delete(id);
    }
}
