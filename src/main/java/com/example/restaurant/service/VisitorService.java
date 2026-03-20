package com.example.restaurant.service;

import com.example.restaurant.entity.Visitor;
import com.example.restaurant.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorService {

    private final VisitorRepository repository;

    public void save(Visitor visitor) {
        repository.save(visitor);
    }

    public void remove(Long id) {
        repository.remove(id);
    }

    public List<Visitor> findAll() {
        return repository.findAll();
    }
}