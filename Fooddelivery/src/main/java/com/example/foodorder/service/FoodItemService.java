package com.example.foodorder.service;

import com.example.foodorder.entity.FoodItem;
import com.example.foodorder.entity.Restaurant;

import java.util.List;

public interface FoodItemService {
   FoodItem saveFoodItem(FoodItem foodItem, int restaurant_id);
   List<FoodItem> getFoodItemsByRestaurant(int id);
}
