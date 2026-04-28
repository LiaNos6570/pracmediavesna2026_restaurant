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

    @GetMapping
    public List<ReviewResponseDTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ReviewResponseDTO create(@RequestBody @Valid ReviewRequestDTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.remove(id);
    }
}