package com.example.foodorder.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cart")
@Data

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
