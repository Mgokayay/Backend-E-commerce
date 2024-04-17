package com.workintech.backend.controller;

import com.workintech.backend.dto.ProductResponse;
import com.workintech.backend.entity.Category;
import com.workintech.backend.entity.Product;
import com.workintech.backend.entity.Store;
import com.workintech.backend.service.CategoryService;
import com.workintech.backend.service.ProductService;
import com.workintech.backend.service.StoreService;
import com.workintech.backend.util.ProductDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    private final CategoryService categoryService;

    private final StoreService storeService;
    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService, StoreService storeService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.storeService = storeService;
    }
    @GetMapping("/")
    public List<ProductResponse> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id){
        return productService.findById(id);
    }
    @GetMapping("/price:asc")
    public List<ProductResponse> findAllByPriceAsc(){
        return productService.findAllByPriceAsc();
    }

    @GetMapping("/price:desc")
    public List<ProductResponse> findAllByPriceDesc(){
        return productService.findAllByPriceDesc();
    }
    @GetMapping("/param")
    public List<ProductResponse> filterByName(@RequestParam String search){
        return productService.filterByName(search);
    }

    @PostMapping("/{categoryId}/{storeId}")
    public ProductResponse save(@RequestBody Product product,@PathVariable Long categoryId,@PathVariable Long storeId){
        Category category = categoryService.findByCategoryId(categoryId);
        Store store = storeService.findByStoreId(storeId);
        product.setCategory(category);
        product.setStore(store);



        productService.save(product);
        category.addProduct(product);
        store.addProduct(product);


        return ProductDtoConvertion.convertProduct(product);
    }
    @DeleteMapping("/{id}")
    public ProductResponse delete(@PathVariable Long id){
        return productService.delete(id);
    }
}
