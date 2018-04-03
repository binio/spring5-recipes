package com.binio.recipes.converters;

import com.binio.recipes.commands.CategoryCommand;
import com.binio.recipes.commands.RecipeCommand;
import com.binio.recipes.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {


    private CategoryCommandToCategory categoryCommand;
    private IngredientCommandToIngredient ingredientCommand;
    private NotesCommandToNotes notesCommand;

    public RecipeCommandToRecipe(
            CategoryCommandToCategory categoryCommand,
            IngredientCommandToIngredient ingredientCommand,
            NotesCommandToNotes notesCommand) {

        this.categoryCommand = categoryCommand;
        this.ingredientCommand = ingredientCommand;
        this.notesCommand = notesCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand rc) {
        if(rc == null){
            return null;
        }

        Recipe recipe = new Recipe();
        recipe.setId(rc.getId());
        recipe.setDescription(rc.getDescription());
        recipe.setDifficulty(rc.getDifficulty());
        recipe.setServings(rc.getServings());
        recipe.setPrepTime(rc.getPrepTime());
        recipe.setDirections(rc.getDirections());
        recipe.setDifficulty(rc.getDifficulty());
        recipe.setCookTime(rc.getCookTime());

        if(rc.getCategories() != null){
            for (CategoryCommand cc: rc.getCategories()) {
                recipe.getCategories().add(categoryCommand.convert(cc));
            }
        }

        if(rc.getIngredients() !=null){
            rc.getIngredients().forEach(i -> recipe.getIngredients().add(ingredientCommand.convert(i)));
        }

        if(rc.getNotes() != null){
            recipe.setNotes(notesCommand.convert(rc.getNotes()));
        }

        return recipe;
    }
}
