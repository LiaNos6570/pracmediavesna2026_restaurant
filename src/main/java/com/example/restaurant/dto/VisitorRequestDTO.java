package com.example.restaurant.dto;

import jakarta.validation.constraints.*;

public record VisitorRequestDTO(
        String name,
        @NotNull Integer age,
        @NotBlank String gender
) {}