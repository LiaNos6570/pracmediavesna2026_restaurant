package com.example.restaurant.service;

import com.example.restaurant.dto.*;
import com.example.restaurant.entity.*;
import com.example.restaurant.mapper.*;
import com.example.restaurant.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final VisitorRepository visitorRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewResponseDTO save(ReviewRequestDTO dto) {

        Visitor visitor = visitorRepository.findById(dto.visitorId()).orElseThrow();
        Restaurant restaurant = restaurantRepository.findById(dto.restaurantId()).orElseThrow();

        Review review = new Review(null, visitor, restaurant, dto.rating(), dto.text());

        reviewRepository.save(review);

        updateRating(restaurant.getId());

        return ReviewMapper.toDTO(review);
    }

    public List<ReviewResponseDTO> findAll() {
        return reviewRepository.findAll().stream().map(ReviewMapper::toDTO).toList();
    }

    public void remove(Long id) {
        reviewRepository.deleteById(id);
    }

    private void updateRating(Long restaurantId) {
        List<Review> reviews = reviewRepository.findAll().stream()
                .filter(r -> r.getRestaurant().getId().equals(restaurantId))
                .toList();

        double avg = reviews.stream().mapToInt(Review::getRating).average().orElse(0);

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow();
        restaurant.setRating(BigDecimal.valueOf(avg));
        restaurantRepository.save(restaurant);
    }
}