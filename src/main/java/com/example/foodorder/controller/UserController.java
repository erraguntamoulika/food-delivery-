package com.example.foodorder.controller;

import com.example.foodorder.entity.User;
import com.example.foodorder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/users")
    public User saveUser(@RequestBody User user)
    {
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id){
        userService.deleteUserById(id);
    }
}
