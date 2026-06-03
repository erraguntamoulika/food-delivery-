package com.example.foodorder.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_items")

@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private int quantity;
    private double price;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "fooditem_id")
    private FoodItem foodItem;
}
