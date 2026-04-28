package com.example.restaurant.dto;

public record ReviewResponseDTO(
        Long id,
        Long visitorId,
        Long restaurantId,
        int rating,
        String text
) {}