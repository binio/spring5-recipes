package com.binio.recipes.converters;

import com.binio.recipes.commands.IngredientCommand;
import com.binio.recipes.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand ingredientCommand) {

        if(ingredientCommand == null) {
            return null;
        }
        return null;
    }
}
