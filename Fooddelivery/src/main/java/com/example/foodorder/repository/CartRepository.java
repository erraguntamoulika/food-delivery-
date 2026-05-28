package com.example.foodorder.repository;

import com.example.foodorder.entity.Cart;
import com.example.foodorder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findByUser(User user);
}
