package com.example.restaurant.dto;

import com.example.restaurant.entity.CuisineType;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record RestaurantRequestDTO(
        @NotBlank String name,
        String description,
        @NotNull CuisineType cuisineType,
        @NotNull BigDecimal averageCheck
) {}