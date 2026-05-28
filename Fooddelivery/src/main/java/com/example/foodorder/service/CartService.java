package com.example.foodorder.service;

import com.example.foodorder.dto.CartRequest;
import com.example.foodorder.entity.CartItem;

import java.util.List;

public interface CartService {
    CartItem addToCart(CartRequest cartRequest);
    List<CartItem> getCartByUser(int userId);
    void  removeCartItem(int cartItemId);
    CartItem updateCartItem(int cartItemId, int quantity);
}
