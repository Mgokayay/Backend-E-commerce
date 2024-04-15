package com.workintech.backend.service;

import com.workintech.backend.dto.ProductResponse;
import com.workintech.backend.entity.Product;

import java.util.List;

public interface ProductService {

    ProductResponse save(Product product);

    List<ProductResponse> findAll();

    ProductResponse findById(Long id);

    ProductResponse delete(Long id);
}
