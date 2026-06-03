package com.example.foodorder.service;

import com.example.foodorder.entity.User;

import java.util.List;

public interface UserService {

   User saveUser(User user);
   List<User> getAllUsers();
   User getUserById(int id);
   void deleteUserById(int id);
}
