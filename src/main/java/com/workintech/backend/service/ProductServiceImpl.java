package com.workintech.backend.service;

import com.workintech.backend.dto.ProductResponse;
import com.workintech.backend.entity.Product;
import com.workintech.backend.exceptions.CommonException;
import com.workintech.backend.repository.ProductRepository;
import com.workintech.backend.util.ProductDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        throw new CommonException("Product is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public ProductResponse delete(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        //TODO 500 hatası için
        if(productOptional.isPresent()){
            productRepository.delete(productOptional.get());
            return ProductDtoConvertion.convertProduct(productOptional.get());
        }
        throw new CommonException("Product is not exist with given id " + id,HttpStatus.NOT_FOUND);
    }

    @Override
    public List<ProductResponse> findAllByPriceAsc() {
        List<Product> products = productRepository.sortByPriceAsc();
        return ProductDtoConvertion.convertProductList(products);
    }

    @Override
    public List<ProductResponse> findAllByPriceDesc() {
        List<Product> products = productRepository.sortByPriceDesc();
        return ProductDtoConvertion.convertProductList(products);
    }

    @Override
    public List<ProductResponse> filterByName(String search) {
        List<Product> products = productRepository.filterByName(search);
        return ProductDtoConvertion.convertProductList(products);
    }
}
