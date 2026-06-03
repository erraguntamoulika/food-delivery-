package com.example.foodorder.repository;

import com.example.foodorder.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {
    List<FoodItem> findByRestaurantId(int id);
}
