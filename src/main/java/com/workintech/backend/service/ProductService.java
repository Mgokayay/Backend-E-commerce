package com.workintech.backend.service;

import com.workintech.backend.entity.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    Product findById(Long id);

    Product delete(Long id);
}
