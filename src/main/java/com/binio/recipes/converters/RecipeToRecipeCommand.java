package com.binio.recipes.converters;

import com.binio.recipes.commands.RecipeCommand;
import com.binio.recipes.domain.Category;
import com.binio.recipes.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;


public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    CategoryToCategoryCommand categoryCommand;
    IngredientToIngredientCommand ingredientCommand;
    NotesToNotesCommand notesCommand;

    public RecipeToRecipeCommand(
            CategoryToCategoryCommand categoryCommand,
            IngredientToIngredientCommand ingredientCommand,
            NotesToNotesCommand notesCommand) {

        this.categoryCommand = categoryCommand;
        this.ingredientCommand = ingredientCommand;
        this.notesCommand = notesCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe recipe) {
        if (recipe == null){
            return null;
        }

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(recipe.getId());
        recipeCommand.setDescription(recipe.getDescription());
        recipeCommand.setDifficulty(recipe.getDifficulty());
        recipeCommand.setServings(recipe.getServings());
        recipeCommand.setPrepTime(recipe.getPrepTime());
        recipeCommand.setDirections(recipe.getDirections());
        recipeCommand.setDifficulty(recipe.getDifficulty());
        recipeCommand.setCookTime(recipe.getCookTime());

        if(recipe.getCategories() != null){
            for (Category cc: recipe.getCategories()) {
                recipeCommand.getCategories().add(categoryCommand.convert(cc));
            }
        }

        if(recipe.getIngredients() !=null){
            recipe.getIngredients().forEach(i -> recipeCommand.getIngredients().add(ingredientCommand.convert(i)));
        }

        if(recipe.getNotes() != null){
            recipeCommand.setNotes(notesCommand.convert(recipe.getNotes()));
        }

        return recipeCommand;

    }
}
