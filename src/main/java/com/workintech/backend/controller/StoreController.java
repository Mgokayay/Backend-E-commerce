package com.workintech.backend.controller;

import com.workintech.backend.dto.StoreResponse;
import com.workintech.backend.entity.Store;
import com.workintech.backend.entity.User;
import com.workintech.backend.service.StoreService;
import com.workintech.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;

    private final UserService userService;
    @Autowired
    public StoreController(StoreService storeService, UserService userService) {
        this.storeService = storeService;
        this.userService = userService;
    }

    @GetMapping("/")
    public List<StoreResponse> findAll(){
        return storeService.findAll();
    }

    @GetMapping("/{id}")
    public StoreResponse findById(@PathVariable Long id){
        return storeService.findById(id);
    }

    @PostMapping("/{userId}")
    public StoreResponse save(@RequestBody Store store,@PathVariable Long userId){
        User user =userService.findByUserId(userId);
        user.setStore(store);
        store.setUser(user);
        return storeService.save(store);
    }

    @DeleteMapping("/{id}")
    public StoreResponse delete(@PathVariable Long id){
        return storeService.delete(id);
    }
}
