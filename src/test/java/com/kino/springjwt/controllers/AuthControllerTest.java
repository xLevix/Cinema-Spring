package com.kino.springjwt.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void login() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/signin")
                        .contentType("application/json")
                        .content("{\"username\":\"user2\",\"password\":\"pass12345\"}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String tokenString = mvcResult.getResponse().getHeader("Authorization");

        mockMvc.perform(get("/filmy/1")
                .header("Authorization", tokenString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andReturn();

        mockMvc.perform(get("/filmy/1")
                .header("Authorization", "Bearer " + tokenString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andReturn();

        mockMvc.perform(get("/filmy/1"))
                .andDo(print())
                .andExpect(status().isUnauthorized())
                .andReturn();
    }

}