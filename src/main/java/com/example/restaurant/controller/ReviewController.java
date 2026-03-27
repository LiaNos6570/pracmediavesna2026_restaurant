package com.example.restaurant.controller;

import com.example.restaurant.dto.*;
import com.example.restaurant.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    //Получить все отзывы
    @GetMapping
    public List<ReviewResponseDTO> getAll() {
        return service.findAll();
    }

    //Добавить отзыв
    @PostMapping
    public ReviewResponseDTO create(@RequestBody @Valid ReviewRequestDTO dto) {
        return service.save(dto);
    }

    //Удалить отзыв
    @DeleteMapping
    public void delete(
            @RequestParam Long visitorId,
            @RequestParam Long restaurantId
    ) {
        service.remove(visitorId, restaurantId);
    }
}