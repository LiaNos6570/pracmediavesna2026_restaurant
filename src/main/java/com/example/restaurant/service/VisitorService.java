package com.example.restaurant.service;

import com.example.restaurant.dto.*;
import com.example.restaurant.mapper.*;
import com.example.restaurant.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorService {

    private final VisitorRepository repository;

    public VisitorResponseDTO save(VisitorRequestDTO dto) {
        return VisitorMapper.toDTO(repository.save(VisitorMapper.toEntity(dto)));
    }

    public List<VisitorResponseDTO> findAll() {
        return repository.findAll().stream().map(VisitorMapper::toDTO).toList();
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }
}