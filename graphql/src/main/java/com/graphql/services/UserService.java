package com.graphql.services;

import com.graphql.entities.User;
import com.graphql.helper.ExceptionHandler;
import com.graphql.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public User createUser(User user){
        return userRepo.save(user);
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User getUser(int userId){
        User user = userRepo.findById(userId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);
        return user;
    }

    public User updateUser(int userId, User user){
        User user2 = userRepo.findById(userId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setPhone(user.getPhone());

        return userRepo.save(user2);
    }
    public boolean deleteUser(int userId){
        User user = userRepo.findById(userId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);
        userRepo.delete(user);
        return true;
    }
}
