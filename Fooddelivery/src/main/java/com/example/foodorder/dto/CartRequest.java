package com.example.foodorder.dto;

import lombok.Data;

@Data
public class CartRequest {

     private int userId;
     private int foodItemId;
     private int quantity;

}
      