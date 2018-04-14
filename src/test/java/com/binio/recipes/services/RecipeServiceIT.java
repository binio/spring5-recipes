package com.binio.recipes.services;

import java.util.List;

import javax.transaction.Transactional;

import com.binio.recipes.commands.RecipeCommand;
import com.binio.recipes.converters.RecipeCommandToRecipe;
import com.binio.recipes.converters.RecipeToRecipeCommand;
import com.binio.recipes.domain.Recipe;
import com.binio.recipes.repositories.RecipeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceIT {

    @Autowired
    RecipeService recipeService;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;
    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;


    @Test
    @Transactional
    public void testSaveNewDescription() {

        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe recipe = recipes.iterator().next();
        RecipeCommand recipeCommand = recipeToRecipeCommand.convert(recipe);

        recipeCommand.setDescription("New description");
        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(recipeCommand);
    }



}
