package com.example.foodorder.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cart_items")
@Data

public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="fooditem_id")
    private FoodItem foodItem;
}
