package com.helloworld.helloworld.controller;

import com.helloworld.helloworld.model.UserTypeModel;
import com.helloworld.helloworld.service.UserTypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserTypeController {
    @Autowired
    UserTypeServiceImp userTypeServiceImp;

    //Insert data
    @PostMapping("/user/add")
    public void addUser(@RequestBody UserTypeModel userTypeModel) {
        userTypeServiceImp.addUser(userTypeModel);
    }

    //Get all user data
    @GetMapping("/users")
    public List<UserTypeModel> getAllUsers() {
        return userTypeServiceImp.getAllUser();
    }

    //Get user by id
    @GetMapping("/users/{id}")
    public UserTypeModel getUserById(@PathVariable("id") int id) {
        return userTypeServiceImp.getUserById(id);
    }

    //delete data
    @DeleteMapping("/users/delete/{id}")
    public void deleteUserById(@PathVariable("id") int id) {
        userTypeServiceImp.deleteByIdUser(id);
    }


}
