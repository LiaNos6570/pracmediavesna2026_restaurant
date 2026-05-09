package com.example.restaurant.controller;

import com.example.restaurant.service.VisitorService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VisitorController.class)
class VisitorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VisitorService service;

    @Test
    void testGetAll() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk());
    }

    @Test
    void testCreate() throws Exception {
        String json = """
                {
                  "name": "Alex",
                  "age": 25,
                  "gender": "M"
                }
                """;

        mockMvc.perform(post("/api/users")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isOk());
    }
}