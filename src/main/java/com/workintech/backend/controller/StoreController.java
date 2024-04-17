package com.workintech.backend.controller;

import com.workintech.backend.dto.StoreResponse;
import com.workintech.backend.entity.Store;
import com.workintech.backend.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;
    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/")
    public List<StoreResponse> findAll(){
        return storeService.findAll();
    }

    @GetMapping("/{id}")
    public StoreResponse findById(@PathVariable Long id){
        return storeService.findById(id);
    }

    @PostMapping
    public StoreResponse save(@RequestBody Store store){
        return storeService.save(store);
    }

    @DeleteMapping("/{id}")
    public StoreResponse delete(@PathVariable Long id){
        return storeService.delete(id);
    }
}
