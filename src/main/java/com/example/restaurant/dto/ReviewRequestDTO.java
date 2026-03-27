package com.example.restaurant.dto;

import jakarta.validation.constraints.*;

public record ReviewRequestDTO(
        @NotNull Long visitorId,
        @NotNull Long restaurantId,
        @Min(1) @Max(5) int rating,
        String text
) {}