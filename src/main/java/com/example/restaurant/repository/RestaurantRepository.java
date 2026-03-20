package com.example.restaurant.repository;

import com.example.restaurant.entity.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RestaurantRepository {

    private final List<Restaurant> restaurants = new ArrayList<>();

    public void save(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public void remove(Long id) {
        restaurants.removeIf(r -> r.getId().equals(id));
    }

    public List<Restaurant> findAll() {
        return restaurants;
    }

    public Optional<Restaurant> findById(Long id) {
        return restaurants.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }
}