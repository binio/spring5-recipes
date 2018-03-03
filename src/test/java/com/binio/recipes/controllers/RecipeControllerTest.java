package com.binio.recipes.controllers;

import com.binio.recipes.domain.Recipe;
import com.binio.recipes.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class RecipeControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    private RecipeController recipeController;

    @Before
    public void setup() throws Exception{
        MockitoAnnotations.initMocks(this);
        recipeController = new RecipeController(recipeService);
    }

    @Test
    public void testPathAndView() throws Exception{
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeService.findById(1L)).thenReturn(recipe);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("show"));
    }
}