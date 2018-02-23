package com.binio.recipes.services;

import com.binio.recipes.domain.Recipe;
import com.binio.recipes.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Iterable<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}
