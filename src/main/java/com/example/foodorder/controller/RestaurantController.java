package com.example.foodorder.controller;

import com.example.foodorder.entity.Restaurant;
import com.example.foodorder.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/restaurants")
    public Restaurant saveRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.saveRestaurant(restaurant);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }
}
