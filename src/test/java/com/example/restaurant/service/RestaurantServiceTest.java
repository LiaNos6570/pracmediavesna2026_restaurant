package com.example.restaurant.service;

import com.example.restaurant.dto.*;
import com.example.restaurant.entity.*;
import com.example.restaurant.repository.*;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantServiceTest {

    @Mock
    private RestaurantRepository repository;

    @InjectMocks
    private RestaurantService service;

    public RestaurantServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        RestaurantRequestDTO dto = new RestaurantRequestDTO(
                "Pizza", "desc", CuisineType.ITALIAN, BigDecimal.valueOf(10)
        );

        when(repository.save(any()))
                .thenReturn(new Restaurant(1L, "Pizza", "desc", CuisineType.ITALIAN, BigDecimal.TEN, BigDecimal.ZERO));

        var result = service.save(dto);

        assertEquals("Pizza", result.name());
    }
}
