package com.example.foodorder.service;

import com.example.foodorder.entity.Restaurant;
import com.example.foodorder.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

     public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
    public List<Restaurant> getAllRestaurants() {

         return restaurantRepository.findAll();
    }
}
