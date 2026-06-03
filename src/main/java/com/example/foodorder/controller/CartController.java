package com.example.foodorder.controller;


import com.example.foodorder.dto.CartRequest;
import com.example.foodorder.entity.CartItem;
import com.example.foodorder.repository.CartItemRepository;
import com.example.foodorder.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/cart/add")
    public CartItem addToCart(@RequestBody CartRequest cartRequest) {
        return cartService.addToCart(cartRequest);
    }

    @GetMapping("/cart/{userId}")
    public List<CartItem> getCartByUser( @PathVariable int userId){
        return cartService.getCartByUser(userId);
    }

    @DeleteMapping("/cartItems/{cartItemId}")
    public void removeCartItem(@PathVariable int cartItemId){
        cartService.removeCartItem(cartItemId);
    }
    @PutMapping("/cartItems/{cartItemId}")
    public CartItem updateCartItem(@PathVariable int cartItemId,@RequestParam int quantity) {
        return cartService.updateCartItem(cartItemId,quantity);
    }

// maven , maven clean install` , docker , pom.xml, system design, jar file creation , how to run where to run maven clean install , jar file  as a bundle and sent to (deployed in) AWS , newrellick application use
}
