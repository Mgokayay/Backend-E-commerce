package com.workintech.backend.controller;

import com.workintech.backend.entity.Category;
import com.workintech.backend.entity.Product;
import com.workintech.backend.service.CategoryService;
import com.workintech.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    private final CategoryService categoryService;
    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }
    @GetMapping("/")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping("/{categoryId}")
    public Product save(@RequestBody Product product,@PathVariable Long categoryId){
        Category category = categoryService.findById(categoryId);
        product.setCategory(category);
        category.addProduct(product);
        categoryService.save(category);
        productService.save(product);


        return product;
    }
    @DeleteMapping("/{id}")
    public Product delete(@PathVariable Long id){
        return productService.delete(id);
    }
}
