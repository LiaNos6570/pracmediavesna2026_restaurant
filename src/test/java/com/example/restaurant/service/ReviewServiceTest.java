package com.example.restaurant.service;

import com.example.restaurant.dto.*;
import com.example.restaurant.entity.*;
import com.example.restaurant.repository.*;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private VisitorRepository visitorRepository;

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private ReviewService service;

    public ReviewServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        ReviewRequestDTO dto = new ReviewRequestDTO(1L, 1L, 5, "Good");

        when(visitorRepository.findById(1L))
                .thenReturn(Optional.of(new Visitor(1L, "A", 20, "M")));

        when(restaurantRepository.findById(1L))
                .thenReturn(Optional.of(new Restaurant(1L, "R", "", CuisineType.ITALIAN, null, null)));

        when(reviewRepository.save(any())).thenReturn(null);

        var result = service.save(dto);

        assertEquals(5, result.rating());
    }
}
