package com.example.restaurant.service;

import com.example.restaurant.dto.VisitorRequestDTO;
import com.example.restaurant.dto.VisitorResponseDTO;
import com.example.restaurant.entity.Visitor;
import com.example.restaurant.mapper.VisitorMapper;
import com.example.restaurant.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorService {

    private final VisitorRepository repository;

    public VisitorResponseDTO save(Long id, VisitorRequestDTO dto) {
        Visitor visitor = VisitorMapper.toEntity(id, dto);
        repository.save(visitor);
        return VisitorMapper.toDTO(visitor);
    }

    public List<VisitorResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(VisitorMapper::toDTO)
                .toList();
    }

    public void remove(Long id) {
        repository.remove(id);
    }
}