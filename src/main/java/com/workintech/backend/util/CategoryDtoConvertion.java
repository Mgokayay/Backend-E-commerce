package com.workintech.backend.util;

import com.workintech.backend.dto.CategoryResponse;
import com.workintech.backend.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDtoConvertion {

    public static List<CategoryResponse> convertCategoryList(List<Category> categories){
        List<CategoryResponse> categoryResponses=new ArrayList<>();

        categories.stream().forEach(category -> categoryResponses.add(new CategoryResponse(category.getId(),category.getCode()
        ,category.getGender(),category.getImg(),category.getRating(),category.getTitle(),category.getProducts())));
        return categoryResponses;
    }

    public static CategoryResponse categoryResponse(Category category){
        return new CategoryResponse(category.getId(),category.getCode()
                ,category.getGender(),category.getImg(),category.getRating(),category.getTitle(),category.getProducts());
    }

}
