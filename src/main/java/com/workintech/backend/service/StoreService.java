package com.workintech.backend.service;

import com.workintech.backend.dto.StoreResponse;
import com.workintech.backend.entity.Store;

import java.util.List;

public interface StoreService {

    StoreResponse save(Store store);

    List<StoreResponse> findAll();

    StoreResponse findById(Long id);

    StoreResponse delete(Long id);

    Store findByStoreId(Long id);
}
