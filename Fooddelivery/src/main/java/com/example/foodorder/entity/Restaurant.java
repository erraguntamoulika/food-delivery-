package com.example.foodorder.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="restaurants")
@Data
public class Restaurant {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String location;
    private double rating;




}
