package com.example.restaurant.service;

import com.example.restaurant.dto.*;
import com.example.restaurant.mapper.*;
import com.example.restaurant.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantResponseDTO save(RestaurantRequestDTO dto) {
        return RestaurantMapper.toDTO(repository.save(RestaurantMapper.toEntity(dto)));
    }

    public List<RestaurantResponseDTO> findAll() {
        return repository.findAll().stream().map(RestaurantMapper::toDTO).toList();
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }
}