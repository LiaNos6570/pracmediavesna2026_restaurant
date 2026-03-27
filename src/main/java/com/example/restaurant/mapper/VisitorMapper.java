package com.example.restaurant.mapper;

import com.example.restaurant.dto.*;
import com.example.restaurant.entity.*;

public class VisitorMapper {

    public static Visitor toEntity(Long id, VisitorRequestDTO dto) {
        return new Visitor(id, dto.name(), dto.age(), dto.gender());
    }

    public static VisitorResponseDTO toDTO(Visitor v) {
        return new VisitorResponseDTO(
                v.getId(),
                v.getName(),
                v.getAge(),
                v.getGender()
        );
    }
}