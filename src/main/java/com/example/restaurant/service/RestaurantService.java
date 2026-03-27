package com.example.restaurant.service;

import com.example.restaurant.dto.*;
import com.example.restaurant.entity.Restaurant;
import com.example.restaurant.mapper.RestaurantMapper;
import com.example.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantResponseDTO save(Long id, RestaurantRequestDTO dto) {
        Restaurant restaurant = RestaurantMapper.toEntity(id, dto);
        restaurant.setRating(BigDecimal.ZERO);

        repository.save(restaurant);

        return RestaurantMapper.toDTO(restaurant);
    }

    public List<RestaurantResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(RestaurantMapper::toDTO)
                .toList();
    }

    public void remove(Long id) {
        repository.remove(id);
    }
}