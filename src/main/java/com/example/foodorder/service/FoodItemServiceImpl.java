package com.example.foodorder.service;
import com.example.foodorder.entity.FoodItem;
import com.example.foodorder.entity.Restaurant;
import com.example.foodorder.repository.FoodItemRepository;
import com.example.foodorder.repository.RestaurantRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    FoodItemRepository foodItemRepository;
    @Autowired
    RestaurantRepository restaurantRepository;

    public FoodItem saveFoodItem( FoodItem foodItem, int restaurant_id) {
        Restaurant restaurant = restaurantRepository.findById(restaurant_id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        foodItem.setRestaurant(restaurant);
        return foodItemRepository.save(foodItem);
    }

    @Override
    public List<FoodItem> getFoodItemsByRestaurant(int id) {
        return foodItemRepository.findByRestaurantId(id);
    }
}
