package com.binio.recipes.services;

import com.binio.recipes.commands.RecipeCommand;
import com.binio.recipes.converters.RecipeCommandToRecipe;
import com.binio.recipes.converters.RecipeToRecipeCommand;
import com.binio.recipes.domain.Recipe;
import com.binio.recipes.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private  final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, final RecipeCommandToRecipe recipeCommandToRecipe, final RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    public Set<Recipe> getAllRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    public Recipe findById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if(!recipe.isPresent()){
            throw  new RuntimeException("Recipe not found");
        }

        return recipe.get();
    }

    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(recipeCommand);
        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved recipeID: " + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }
}

