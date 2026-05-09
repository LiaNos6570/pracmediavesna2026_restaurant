package com.example.restaurant.controller;

import com.example.restaurant.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReviewController.class)
class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ReviewService service;

    @Test
    void testGetAll() throws Exception {

        mockMvc.perform(get("/api/reviews"))
                .andExpect(status().isOk());
    }

    @Test
    void testCreate() throws Exception {

        String json = """
                {
                  "visitorId": 1,
                  "restaurantId": 1,
                  "rating": 5,
                  "text": "Excellent"
                }
                """;

        mockMvc.perform(post("/api/reviews")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    void testDelete() throws Exception {

        mockMvc.perform(delete("/api/reviews/1"))
                .andExpect(status().isOk());
    }
}