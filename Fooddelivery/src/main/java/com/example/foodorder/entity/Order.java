package com.example.foodorder.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")

@Data
public class Order {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;
      private double totalAmount;
      private String status;
      private LocalDateTime orderdate;

      @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
      List<OrderItem> orderItems = new ArrayList<>();

      @ManyToOne
      @JoinColumn(name = "user_id")
      private User user;
}
