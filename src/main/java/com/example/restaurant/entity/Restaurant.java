package com.example.restaurant.entity;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Restaurant {
    private Long id;
    private String name;
    private String description;
    private CuisineType cuisineType;
    private BigDecimal averageCheck;
    private BigDecimal rating;
}