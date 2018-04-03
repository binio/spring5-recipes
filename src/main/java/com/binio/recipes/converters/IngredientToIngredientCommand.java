package com.binio.recipes.converters;

import com.binio.recipes.commands.IngredientCommand;
import com.binio.recipes.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient ingredient) {
        if(ingredient == null) {
            return null;
        }
        IngredientCommand ic = new IngredientCommand();
        ic.setId(ingredient.getId());
        ic.setDescription(ingredient.getDescription());
        ic.setAmout(ingredient.getAmout());
        ic.setUnitMeasure(ingredient.getUnitMeasure());

        return ic;
    }
}
