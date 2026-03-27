package com.example.restaurant.controller;

import com.example.restaurant.dto.*;
import com.example.restaurant.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class VisitorController {

    private final VisitorService service;

    @GetMapping
    public List<VisitorResponseDTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public VisitorResponseDTO create(@RequestBody @Valid VisitorRequestDTO dto) {
        return service.save(System.currentTimeMillis(), dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.remove(id);
    }
}