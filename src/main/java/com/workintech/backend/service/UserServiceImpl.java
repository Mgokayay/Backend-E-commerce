package com.workintech.backend.service;

import com.workintech.backend.dto.UserResponse;
import com.workintech.backend.entity.User;
import com.workintech.backend.exceptions.CommonException;
import com.workintech.backend.repository.UserRepository;
import com.workintech.backend.util.UserDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> findAll() {
        List<User> users = userRepository.findAll();
        return UserDtoConvertion.convertUserList(users);
    }

    @Override
    public UserResponse save(User user) {
        userRepository.save(user);
        return UserDtoConvertion.convertUser(user);
    }

    @Override
    public UserResponse findById(Long id) {
        Optional<User> userOptional= userRepository.findById(id);
        if(userOptional.isPresent()){
            return UserDtoConvertion.convertUser(userOptional.get());
        }
         throw new CommonException("User is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public UserResponse delete(Long id) {
        Optional<User> userOptional=userRepository.findById(id);
        if(userOptional.isPresent()){
            userRepository.delete(userOptional.get());
            return UserDtoConvertion.convertUser(userOptional.get());
        }
        throw new CommonException("User is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }
}
