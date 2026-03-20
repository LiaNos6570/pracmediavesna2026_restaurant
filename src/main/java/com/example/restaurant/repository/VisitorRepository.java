package com.example.restaurant.repository;

import com.example.restaurant.entity.Visitor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class VisitorRepository {

    private final List<Visitor> visitors = new ArrayList<>();

    public void save(Visitor visitor) {
        visitors.add(visitor);
    }

    public void remove(Long id) {
        visitors.removeIf(v -> v.getId().equals(id));
    }

    public List<Visitor> findAll() {
        return visitors;
    }
}