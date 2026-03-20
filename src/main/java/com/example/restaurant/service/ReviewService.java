package com.example.restaurant.service;

import com.example.restaurant.entity.Restaurant;
import com.example.restaurant.entity.Review;
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

    public void save(Review review) {
        reviewRepository.save(review);
        updateRestaurantRating(review.getRestaurantId());
    }

    public void remove(Long visitorId, Long restaurantId) {
        reviewRepository.remove(visitorId, restaurantId);
        updateRestaurantRating(restaurantId);
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
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

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow();
        restaurant.setRating(BigDecimal.valueOf(avg));
    }
}