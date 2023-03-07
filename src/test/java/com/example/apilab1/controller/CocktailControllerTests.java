package com.example.apilab1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class CocktailControllerTests {
    @Autowired
    private MockMvc mockMvcController;
    @Test
    public void testGetCocktailLover() throws Exception {
        String expectedContent = "I LOVE cocktails!";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/cocktailLover"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string
                        (expectedContent));
    }

    @Test
    public void testGetCocktailWithoutRequestParams() throws Exception {
        String expectedValue = "mojito";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/cocktail"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").
                        value(expectedValue));
    }
    @Test
    public void testGetCocktailWithRequestParams() throws Exception {
        String expectedValue = "screwdriver";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/cocktail").param("name",
                                "screwdriver"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").
                        value(expectedValue));
    }
}
