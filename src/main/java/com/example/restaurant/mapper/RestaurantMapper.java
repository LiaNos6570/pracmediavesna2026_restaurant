package com.example.restaurant.mapper;

import com.example.restaurant.dto.*;
import com.example.restaurant.entity.*;

public class RestaurantMapper {

    public static Restaurant toEntity(Long id, RestaurantRequestDTO dto) {
        return new Restaurant(
                id,
                dto.name(),
                dto.description(),
                dto.cuisineType(),
                dto.averageCheck(),
                null
        );
    }

    public static RestaurantResponseDTO toDTO(Restaurant r) {
        return new RestaurantResponseDTO(
                r.getId(),
                r.getName(),
                r.getDescription(),
                r.getCuisineType(),
                r.getAverageCheck(),
                r.getRating()
        );
    }
}