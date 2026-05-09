package com.example.restaurant.controller;

import com.example.restaurant.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RestaurantService service;

    @Test
    void testGetAll() throws Exception {
        mockMvc.perform(get("/api/restaurants"))
                .andExpect(status().isOk());
    }

    @Test
    void testCreate() throws Exception {

        String json = """
                {
                  "name": "Pizza Place",
                  "description": "Nice food",
                  "cuisineType": "ITALIAN",
                  "averageCheck": 15
                }
                """;

        mockMvc.perform(post("/api/restaurants")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    void testDelete() throws Exception {

        mockMvc.perform(delete("/api/restaurants/1"))
                .andExpect(status().isOk());
    }
}