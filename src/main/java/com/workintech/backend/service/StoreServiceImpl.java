package com.workintech.backend.service;

import com.workintech.backend.dto.StoreResponse;
import com.workintech.backend.entity.Store;
import com.workintech.backend.exceptions.CommonException;
import com.workintech.backend.repository.StoreRepository;
import com.workintech.backend.util.StoreDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;
    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public StoreResponse save(Store store) {
        storeRepository.save(store);
        return StoreDtoConvertion.convertStore( store);
    }

    @Override
    public List<StoreResponse> findAll() {
        List<Store> stores = storeRepository.findAll();
        return StoreDtoConvertion.convertStoreList(stores);
    }

    @Override
    public StoreResponse findById(Long id) {
        Optional<Store> storeOptional = storeRepository.findById(id);
        if(storeOptional.isPresent()){
            return StoreDtoConvertion.convertStore(storeOptional.get());
        }
       throw  new CommonException("Store is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public StoreResponse delete(Long id) {
        Optional<Store> storeOptional = storeRepository.findById(id);
        if(storeOptional.isPresent()){
             storeRepository.delete(storeOptional.get());
             return StoreDtoConvertion.convertStore(storeOptional.get());

        }
        throw  new CommonException("Store is not exist with given id " + id,HttpStatus.NOT_FOUND);
    }

    @Override
    public Store findByStoreId(Long id) {
        Optional<Store> storeOptional=storeRepository.findById(id);
        if(storeOptional.isPresent()){
            return storeOptional.get();
        }
        throw  new CommonException("Store is not exist with given id " + id,HttpStatus.NOT_FOUND);
    }
}
