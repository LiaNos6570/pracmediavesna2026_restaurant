package com.example.restaurant.mapper;

import com.example.restaurant.dto.*;
import com.example.restaurant.entity.*;

public class ReviewMapper {

    public static Review toEntity(ReviewRequestDTO dto) {
        return new Review(
                dto.visitorId(),
                dto.restaurantId(),
                dto.rating(),
                dto.text()
        );
    }

    public static ReviewResponseDTO toDTO(Review r) {
        return new ReviewResponseDTO(
                r.getVisitorId(),
                r.getRestaurantId(),
                r.getRating(),
                r.getText()
        );
    }
}