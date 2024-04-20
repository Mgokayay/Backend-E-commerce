package com.workintech.backend.controller;

import com.workintech.backend.dto.UserResponse;
import com.workintech.backend.entity.User;
import com.workintech.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/")
    public List<UserResponse> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public UserResponse delete(@PathVariable Long id){
        return userService.delete(id);
    }
}
