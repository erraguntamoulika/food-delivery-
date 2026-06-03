package com.example.foodorder.service;

import com.example.foodorder.entity.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant saveRestaurant(Restaurant restaurant);
    List<Restaurant> getAllRestaurants();
}
