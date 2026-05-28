package com.example.foodorder.controller;


import com.example.foodorder.entity.Order;
import com.example.foodorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;


        @PostMapping("/orders/{userId}")
        public Order placeOrder(@PathVariable int userId){
            return orderService.placeOrder(userId);
        }

        @GetMapping("/orders/{userId}")
        public List<Order> getByUserId(@PathVariable int userId){
            return orderService.getOrdersByUserId(userId);
        }

        @PutMapping("/orders/{orderId}")
        public Order updateOrderStatus(@PathVariable  int orderId,@RequestParam String status){
            return orderService.updateOrderStatus(orderId,  status);
        }

}
