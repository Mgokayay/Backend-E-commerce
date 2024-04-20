package com.workintech.backend.service;

import com.workintech.backend.dto.UserResponse;
import com.workintech.backend.entity.User;

import java.util.List;

public interface UserService {

    List<UserResponse> findAll();

    UserResponse save(User user);

    UserResponse findById(Long id);

    UserResponse delete(Long id);




}
