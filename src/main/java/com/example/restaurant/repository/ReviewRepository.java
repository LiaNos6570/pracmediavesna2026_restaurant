package com.example.restaurant.repository;

import com.example.restaurant.entity.Review;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ReviewRepository {

    private final List<Review> reviews = new ArrayList<>();

    public void save(Review review) {
        reviews.add(review);
    }

    public void remove(Long visitorId, Long restaurantId) {
        reviews.removeIf(r ->
                r.getVisitorId().equals(visitorId)
                        && r.getRestaurantId().equals(restaurantId));
    }

    public List<Review> findAll() {
        return reviews;
    }

    public Optional<Review> findById(Long visitorId, Long restaurantId) {
        return reviews.stream()
                .filter(r -> r.getVisitorId().equals(visitorId)
                        && r.getRestaurantId().equals(restaurantId))
                .findFirst();
    }
}