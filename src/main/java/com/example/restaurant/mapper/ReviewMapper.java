package com.example.restaurant.mapper;

import com.example.restaurant.dto.*;
import com.example.restaurant.entity.*;

public class ReviewMapper {

    public static ReviewResponseDTO toDTO(Review r) {
        return new ReviewResponseDTO(
                r.getId(),
                r.getVisitor().getId(),
                r.getRestaurant().getId(),
                r.getRating(),
                r.getText()
        );
    }
}