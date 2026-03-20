package com.example.restaurant.runner;

import com.example.restaurant.entity.*;
import com.example.restaurant.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class AppRunner implements CommandLineRunner {

    private final VisitorService visitorService;
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;

    @Override
    public void run(String... args) {

        // 👤 Посетители
        visitorService.save(new Visitor(1L, "Alex", 25, "M"));
        visitorService.save(new Visitor(2L, null, 30, "F")); // аноним
        visitorService.save(new Visitor(3L, "John", 22, "M"));

        // 🍕 Рестораны
        restaurantService.save(new Restaurant(
                1L,
                "Pizza Place",
                "Italian food",
                CuisineType.ITALIAN,
                BigDecimal.valueOf(15),
                BigDecimal.ZERO
        ));

        restaurantService.save(new Restaurant(
                2L,
                "China Town",
                "Chinese food",
                CuisineType.CHINESE,
                BigDecimal.valueOf(12),
                BigDecimal.ZERO
        ));

        // ⭐ Оценки
        reviewService.save(new Review(1L, 1L, 5, "Top"));
        reviewService.save(new Review(2L, 1L, 3, ""));
        reviewService.save(new Review(3L, 1L, 4, "Good"));

        reviewService.save(new Review(1L, 2L, 2, "Not great"));
        reviewService.save(new Review(2L, 2L, 5, "Perfect"));

        // 📊 Вывод
        System.out.println("=== РЕСТОРАНЫ ===");
        restaurantService.findAll().forEach(System.out::println);

        System.out.println("=== ОТЗЫВЫ ===");
        reviewService.findAll().forEach(System.out::println);
    }
}