package com.example.foodorder.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="fooditems")


@Data
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private double price;
    private String description;

    @ManyToOne
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;




}
