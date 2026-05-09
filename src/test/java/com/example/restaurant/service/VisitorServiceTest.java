package com.example.restaurant.service;

import com.example.restaurant.dto.*;
import com.example.restaurant.entity.Visitor;
import com.example.restaurant.repository.VisitorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class VisitorServiceTest {

    @Mock
    private VisitorRepository repository;

    @InjectMocks
    private VisitorService service;

    public VisitorServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        VisitorRequestDTO dto = new VisitorRequestDTO("Alex", 25, "M");

        when(repository.save(any())).thenReturn(new Visitor(1L, "Alex", 25, "M"));

        VisitorResponseDTO result = service.save(dto);

        assertEquals("Alex", result.name());
        verify(repository, times(1)).save(any());
    }

    @Test
    void testFindAll() {
        when(repository.findAll()).thenReturn(
                List.of(new Visitor(1L, "Alex", 25, "M"))
        );

        List<VisitorResponseDTO> list = service.findAll();

        assertEquals(1, list.size());
    }
}