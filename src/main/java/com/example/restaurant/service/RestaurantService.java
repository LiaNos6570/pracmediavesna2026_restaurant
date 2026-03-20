package com.example.restaurant.service;

import com.example.restaurant.entity.Restaurant;
import com.example.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository repository;

    public void save(Restaurant restaurant) {
        repository.save(restaurant);
    }

    public void remove(Long id) {
        repository.remove(id);
    }

    public List<Restaurant> findAll() {
        return repository.findAll();
    }
}