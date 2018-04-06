package com.binio.recipes.converters;

import com.binio.recipes.commands.IngredientCommand;
import com.binio.recipes.commands.UnitOfMeasureCommand;
import com.binio.recipes.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    UnitOfMeasureToUnitOfMeasureCommand uomConverter = new UnitOfMeasureToUnitOfMeasureCommand();

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient ingredient) {
        if(ingredient == null) {
            return null;
        }
        UnitOfMeasureCommand unitOfMeasureCommand = null;

        if(ingredient.getUnitMeasure() != null ) {
            unitOfMeasureCommand = uomConverter.convert(ingredient.getUnitMeasure());
        }
        IngredientCommand ic = new IngredientCommand();
        ic.setId(ingredient.getId());
        ic.setDescription(ingredient.getDescription());
        ic.setAmout(ingredient.getAmout());
        ic.setUnitOfMeasureCommand(unitOfMeasureCommand);

        return ic;
    }
}
