package com.workintech.backend.util;

import com.workintech.backend.dto.ProductResponse;
import com.workintech.backend.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDtoConvertion {

    public static List<ProductResponse> convertProductList(List<Product> products){
           List<ProductResponse> productResponses = new ArrayList<>();

           products.stream().forEach(product -> productResponses.add(new ProductResponse(product.getId(),product.getName(),product.getPrice()
           ,product.getSellCount(),product.getStock(),product.getDescription(),product.getImages(),product.getCategory().getId())));
           return productResponses;
    }

    public static ProductResponse convertProduct(Product product){
        return new ProductResponse(product.getId(),product.getName(),product.getPrice()
                ,product.getSellCount(),product.getStock(),product.getDescription(),product.getImages(),product.getCategory().getId());
    }
}
