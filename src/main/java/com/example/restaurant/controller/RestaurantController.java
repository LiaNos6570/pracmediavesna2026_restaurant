package com.example.restaurant.controller;

import com.example.restaurant.dto.*;
import com.example.restaurant.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
    public class RestaurantController {

        private final RestaurantService service;

        @GetMapping
        public List<RestaurantResponseDTO> getAll() {
            return service.findAll();
        }

        @PostMapping
        public RestaurantResponseDTO create(@RequestBody @Valid RestaurantRequestDTO dto) {
            return service.save(dto);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            service.remove(id);
        }
}