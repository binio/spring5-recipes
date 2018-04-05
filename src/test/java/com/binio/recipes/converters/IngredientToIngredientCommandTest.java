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
    IngredientToIngredientCommand ingredientToIngredientCommand;
    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredientToIngredientCommand = new IngredientToIngredientCommand();
        ingredient = new Ingredient();
        ingredient.setId(INGREDIENT_ID);
        ingredient.setAmout(INGREDIENT_AMOUT);
        ingredient.setUnitMeasure(null);
        ingredient.setDescription(INGREDIENT_DESCRIPTION);
        ingredient.setRecipe(null);

    }

    @Test
    public void convert() {
        IngredientCommand command = ingredientToIngredientCommand.convert(ingredient);
        assertThat(command.getDescription(), is(INGREDIENT_DESCRIPTION));
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