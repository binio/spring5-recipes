package com.binio.recipes.services;

import com.binio.recipes.domain.Recipe;
import com.binio.recipes.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws  Exception{
        MockitoAnnotations.initMocks(this);
            recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getAllRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        Recipe r1 = new Recipe();
        r1.setId(1L);
        r1.setDescription("abc");

        Recipe r2 = new Recipe();
        r1.setId(2L);
        recipes.add(r1);
        recipes.add(r2);

        when(recipeRepository.findAll()).thenReturn(recipes);
        Set<Recipe> result = recipeService.getAllRecipes();
        assertEquals(recipes.size(), result.size());
    }

    @Test
    public void findById() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);
        when(recipeRepository.findById(1L)).thenReturn(recipeOptional);
        Recipe recipeReturned = recipeService.findById(1L);
        assertEquals(recipe,recipeReturned);
    }
}