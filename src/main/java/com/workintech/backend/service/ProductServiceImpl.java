package com.workintech.backend.service;

import com.workintech.backend.entity.Product;
import com.workintech.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {

        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> productOptional= productRepository.findById(id);
        if(productOptional.isPresent()){
            return productOptional.get();
        }
        throw new RuntimeException("Product is not exist with given id " + id);
    }

    @Override
    public Product delete(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            productRepository.delete(productOptional.get());
            return productOptional.get();
        }
        throw new RuntimeException("Product is not exist with given id " + id);
    }
}
