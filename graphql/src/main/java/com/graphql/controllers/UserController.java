package com.graphql.controllers;

import com.graphql.entities.User;
import com.graphql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @MutationMapping
    public User createUser(@Argument String name, @Argument String phone, @Argument String email, @Argument String password){
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        return userService.createUser(user);
    }
    @QueryMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @QueryMapping
    public User getUser(@Argument int userId){
        return userService.getUser(userId);
    }


    @MutationMapping
    public User updateUser(@Argument int userId, @Argument String name, @Argument String phone, @Argument String email, @Argument String password){
        User updatedUser = new User();
        updatedUser.setName(name);
        updatedUser.setPhone(phone);
        updatedUser.setEmail(email);
        updatedUser.setPassword(password);
        return userService.updateUser(userId, updatedUser);
    }

    @MutationMapping
    public boolean deleteUser(@Argument int userId){
        return userService.deleteUser(userId);
    }
}
