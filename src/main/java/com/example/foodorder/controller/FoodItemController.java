package com.example.foodorder.controller;

import com.example.foodorder.entity.FoodItem;
import com.example.foodorder.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodItemController {
    @Autowired
    FoodItemService foodItemService;


    @PostMapping("/fooditems/{restaurant_id}")
    public FoodItem saveFoodItem(@RequestBody FoodItem foodItem, @PathVariable int restaurant_id){
       return foodItemService.saveFoodItem(foodItem,restaurant_id);
    }
    @GetMapping("/fooditems/restaurant/{id}")
    public List<FoodItem> getFoodItemByRestaurantId(@PathVariable int id){
        return foodItemService.getFoodItemsByRestaurant(id);
    }

}
