package com.workintech.backend.service;

import com.workintech.backend.dto.CategoryResponse;
import com.workintech.backend.entity.Category;
import com.workintech.backend.exceptions.CommonException;
import com.workintech.backend.factory.GlobalIdChecker;
import com.workintech.backend.repository.CategoryRepository;
import com.workintech.backend.util.CategoryDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponse save(Category category) {

        categoryRepository.save(category);
        return CategoryDtoConvertion.categoryResponse(category);
    }

    @Override
    public List<CategoryResponse> findAll() {
         List<Category> categories = categoryRepository.findAll();
        return CategoryDtoConvertion.convertCategoryList(categories);
    }

    @Override
    public CategoryResponse findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        GlobalIdChecker.categoryIdChecker(id);
        if(categoryOptional.isPresent()){
            return CategoryDtoConvertion.categoryResponse(categoryOptional.get());
        }
        throw new CommonException("Category is not exist with given id " + id,HttpStatus.BAD_REQUEST);
    }

    @Override
    public CategoryResponse delete(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        GlobalIdChecker.categoryIdChecker(id);
        if(categoryOptional.isPresent()){
            categoryRepository.delete(categoryOptional.get());
            return CategoryDtoConvertion.categoryResponse(categoryOptional.get());
        }
        throw new CommonException("Category is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Category findByCategoryId(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        GlobalIdChecker.categoryIdChecker(id);
        if(categoryOptional.isPresent()){
            return categoryOptional.get();
        }
        throw new CommonException("Category is not exist with given id " + id,HttpStatus.NOT_FOUND);
    }
}
