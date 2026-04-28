package com.example.restaurant.mapper;

import com.example.restaurant.dto.*;
import com.example.restaurant.entity.*;

import java.math.BigDecimal;

public class RestaurantMapper {

    public static Restaurant toEntity(RestaurantRequestDTO dto) {
        return new Restaurant(
                null,
                dto.name(),
                dto.description(),
                dto.cuisineType(),
                dto.averageCheck(),
                BigDecimal.ZERO
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