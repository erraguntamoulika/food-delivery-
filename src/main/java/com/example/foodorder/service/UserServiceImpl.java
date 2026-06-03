package com.example.foodorder.service;

import com.example.foodorder.entity.User;
import com.example.foodorder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    public User saveUser(User user) {
        return userRepository.save(user)    ;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id" + id));
    }

    @Override
    public void deleteUserById(int id) {
         userRepository.deleteById(id);
    }


}
