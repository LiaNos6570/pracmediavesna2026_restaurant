package com.example.restaurant.dto;

import jakarta.validation.constraints.*;

public record VisitorRequestDTO(

        String name,

        @NotNull
        @Min(0)
        Integer age,

        @NotBlank
        String gender

) {}