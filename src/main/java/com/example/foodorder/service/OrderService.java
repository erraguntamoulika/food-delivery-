package com.example.foodorder.service;

import com.example.foodorder.entity.Order;

import java.util.List;


public interface OrderService {
    Order placeOrder(int userId);

    List<Order> getOrdersByUserId(int userId);
    Order updateOrderStatus(int orderId, String status);
}
