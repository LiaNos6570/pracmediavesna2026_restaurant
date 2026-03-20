package com.example.restaurant.entity;

import lombok.*;

@Data
@AllArgsConstructor
public class Visitor {
    private Long id;
    private String name; // может быть null
    private int age;
    private String gender;
}