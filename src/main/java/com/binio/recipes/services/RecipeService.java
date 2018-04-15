package com.binio.recipes.services;

import com.binio.recipes.commands.RecipeCommand;
import com.binio.recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getAllRecipes();
    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

}
