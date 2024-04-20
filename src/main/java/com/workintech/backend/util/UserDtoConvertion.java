package com.workintech.backend.util;

import com.workintech.backend.dto.UserResponse;
import com.workintech.backend.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDtoConvertion {

    public static List<UserResponse> convertUserList(List<User> users){
        List<UserResponse> userResponses = new ArrayList<>();

        users.stream().forEach(user -> userResponses.add(new UserResponse(user.getId(),user.getName()
        ,user.getEmail())));
        return userResponses;
    }

    public static UserResponse convertUser(User user){
    return new UserResponse(user.getId(),user.getName()
            ,user.getEmail());
    }
}
