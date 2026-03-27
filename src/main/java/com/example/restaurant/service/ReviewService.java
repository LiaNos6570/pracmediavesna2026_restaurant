package com.example.restaurant.service;

import com.example.restaurant.dto.*;
import com.example.restaurant.entity.Restaurant;
import com.example.restaurant.entity.Review;
import com.example.restaurant.mapper.ReviewMapper;
import com.example.restaurant.repository.RestaurantRepository;
import com.example.restaurant.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewResponseDTO save(ReviewRequestDTO dto) {
        Review review = ReviewMapper.toEntity(dto);

        reviewRepository.save(review);
        updateRestaurantRating(dto.restaurantId());

        return ReviewMapper.toDTO(review);
    }

    public List<ReviewResponseDTO> findAll() {
        return reviewRepository.findAll().stream()
                .map(ReviewMapper::toDTO)
                .toList();
    }

    public void remove(Long visitorId, Long restaurantId) {
        reviewRepository.remove(visitorId, restaurantId);
        updateRestaurantRating(restaurantId);
    }

    private void updateRestaurantRating(Long restaurantId) {
        List<Review> reviews = reviewRepository.findAll().stream()
                .filter(r -> r.getRestaurantId().equals(restaurantId))
                .toList();

        if (reviews.isEmpty()) return;

        double avg = reviews.stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0);

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow();

        restaurant.setRating(BigDecimal.valueOf(avg));
    }
}