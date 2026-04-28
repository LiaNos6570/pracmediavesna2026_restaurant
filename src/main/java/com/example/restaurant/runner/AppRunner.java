package com.example.restaurant.runner;

import com.example.restaurant.dto.*;
import com.example.restaurant.entity.CuisineType;
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

        //Пользователи
        visitorService.save(
                new VisitorRequestDTO("Alex", 25, "M")
        );

        visitorService.save(
                new VisitorRequestDTO(null, 30, "F")
        );

        // 🍕 Рестораны
        restaurantService.save(
                new RestaurantRequestDTO(
                        "Pizza Place",
                        "Nice pizza",
                        CuisineType.ITALIAN,
                        BigDecimal.valueOf(15)
                )
        );

        //Отзывы
        reviewService.save(
                new ReviewRequestDTO(1L, 1L, 5, "Top")
        );

        reviewService.save(
                new ReviewRequestDTO(2L, 1L, 3, "Normal")
        );

        //Проверка
        restaurantService.findAll().forEach(System.out::println);
    }
}