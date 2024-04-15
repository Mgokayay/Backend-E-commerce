package com.workintech.backend.service;

import com.workintech.backend.dto.ProductResponse;
import com.workintech.backend.entity.Product;
import com.workintech.backend.repository.ProductRepository;
import com.workintech.backend.util.ProductDtoConvertion;
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
    public ProductResponse save(Product product) {
        productRepository.save(product);
        return ProductDtoConvertion.convertProduct(product);
    }

    @Override
    public List<ProductResponse> findAll() {
        List<Product> products = productRepository.findAll();
        return ProductDtoConvertion.convertProductList(products);
    }

    @Override
    public ProductResponse findById(Long id) {
        Optional<Product> productOptional= productRepository.findById(id);
        if(productOptional.isPresent()){
            return ProductDtoConvertion.convertProduct(productOptional.get());
        }
        throw new RuntimeException("Product is not exist with given id " + id);
    }

    @Override
    public ProductResponse delete(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            productRepository.delete(productOptional.get());
            return ProductDtoConvertion.convertProduct(productOptional.get());
        }
        throw new RuntimeException("Product is not exist with given id " + id);
    }
}
