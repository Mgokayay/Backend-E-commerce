package com.workintech.backend.dto;

import com.workintech.backend.entity.Product;

import java.util.List;

public record StoreResponse(Long id, String name, Long phone, Long tax_no, Long bank_account, List<Product> productList) {
}
