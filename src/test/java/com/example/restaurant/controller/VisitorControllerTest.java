package com.example.restaurant.controller;

import com.example.restaurant.service.VisitorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VisitorController.class)
class VisitorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
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