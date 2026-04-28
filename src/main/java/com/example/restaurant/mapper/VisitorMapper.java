package com.example.restaurant.mapper;

import com.example.restaurant.dto.*;
import com.example.restaurant.entity.*;

public class VisitorMapper {

    public static Visitor toEntity(VisitorRequestDTO dto) {
        return new Visitor(null, dto.name(), dto.age(), dto.gender());
    }

    public static VisitorResponseDTO toDTO(Visitor v) {
        return new VisitorResponseDTO(v.getId(), v.getName(), v.getAge(), v.getGender());
    }
}