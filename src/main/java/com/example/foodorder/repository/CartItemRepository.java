package com.example.foodorder.repository;

import com.example.foodorder.entity.Cart;
import com.example.foodorder.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

 List<CartItem> findByCart(Cart cart);
}
