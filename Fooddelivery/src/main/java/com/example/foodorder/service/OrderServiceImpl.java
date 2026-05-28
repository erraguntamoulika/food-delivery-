package com.example.foodorder.service;

import com.example.foodorder.entity.*;
import com.example.foodorder.repository.CartItemRepository;
import com.example.foodorder.repository.CartRepository;
import com.example.foodorder.repository.OrderRepository;
import com.example.foodorder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    CartRepository cartRepository;


    @Override
    public Order placeOrder(int userId){
       User user= userRepository.findById(userId).orElseThrow(() ->new RuntimeException("User not Found"));
       Cart cart= cartRepository.findByUser(user);
       if(cart == null){
           throw new RuntimeException("cart  not found");
       }
        List<CartItem> cartItem = cartItemRepository.findByCart(cart);
       if(cartItem.isEmpty()){
           throw  new RuntimeException("cartitem is empty");
       }
        Order order = new Order();
        order.setUser(user);
        order.setStatus("PLACED");
        order.setOrderdate(LocalDateTime.now());


        double total = 0;

        for (CartItem item : cartItem) {

            OrderItem orderItem = new OrderItem();

            orderItem.setFoodItem(item.getFoodItem());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(item.getFoodItem().getPrice());

            orderItem.setOrder(order);

            order.getOrderItems().add(orderItem);

            total += item.getQuantity() * item.getFoodItem().getPrice();
        }


        order.setTotalAmount(total);
        Order savedOrder = orderRepository.save(order);
        cartItemRepository.deleteAll(cartItem);
        return savedOrder;
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Order updateOrderStatus(int orderId, String status) {
        Order order= orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("orderid not found"));
        order.setStatus(status);
         return orderRepository.save(order);
    }


}



