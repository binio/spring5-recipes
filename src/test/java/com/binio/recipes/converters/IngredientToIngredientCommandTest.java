package com.binio.recipes.converters;

import com.binio.recipes.commands.IngredientCommand;
import com.binio.recipes.domain.Ingredient;
import com.binio.recipes.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class IngredientToIngredientCommandTest {

    public static final long INGREDIENT_ID = 123L;
    public static final BigDecimal INGREDIENT_AMOUT = new BigDecimal(100);
    public static final String INGREDIENT_DESCRIPTION = "description";
    public static final long UNIT_OF_MEASURE_ID = 123L;
    public static final String UNIT_OF_MEASURE_NAME = "kilograms";
    IngredientToIngredientCommand ingredientToIngredientCommand;
    Ingredient ingredient;

    @Before
    public void setUp() {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UNIT_OF_MEASURE_ID);
        uom.setOum(UNIT_OF_MEASURE_NAME);

        ingredientToIngredientCommand = new IngredientToIngredientCommand();
        ingredient = new Ingredient();
        ingredient.setId(INGREDIENT_ID);
        ingredient.setAmout(INGREDIENT_AMOUT);
        ingredient.setUnitMeasure(uom);
        ingredient.setDescription(INGREDIENT_DESCRIPTION);


    }

    @Test
    public void convert() {
        IngredientCommand command = ingredientToIngredientCommand.convert(ingredient);
        assertThat(command.getDescription(), is(INGREDIENT_DESCRIPTION));
        assertThat(command.getAmout(), is(INGREDIENT_AMOUT));
        assertThat(command.getId(), is(INGREDIENT_ID));

        assertThat(command.getUnitOfMeasureCommand().getId(), is(UNIT_OF_MEASURE_ID));
        assertThat(command.getUnitOfMeasureCommand().getOum(), is(UNIT_OF_MEASURE_NAME));
    }

    @Test
    public void convertEmptyObject() {
        assertNotNull(ingredientToIngredientCommand.convert(new Ingredient()));
    }

    @Test
    public void convertNull() {
        assertNull(ingredientToIngredientCommand.convert(null));

    }
}