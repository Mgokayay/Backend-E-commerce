package com.workintech.backend.repository;

import com.workintech.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> sortByPriceAsc();

    @Query("SELECT p FROM Product p ORDER BY p.price DESC")
    List<Product> sortByPriceDesc();

    @Query("SELECT p FROM Product p WHERE p.name ilike %:search%")
    List<Product> filterByName(String search);
}
