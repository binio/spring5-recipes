package com.binio.recipes.converters;

import com.binio.recipes.commands.CategoryCommand;
import com.binio.recipes.commands.IngredientCommand;
import com.binio.recipes.commands.UnitOfMeasureCommand;
import com.binio.recipes.domain.Ingredient;
import com.binio.recipes.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class IngredientCommandToIngredientTest {

    public static final BigDecimal CMD_AMOUT = new BigDecimal(1000);
    public static final String CMD_DESCRIPTION = "description";
    public static final long CMD_ID = 123L;
    public static final String UOM_KILOGRAMS = "kilograms";
    public static final long UOM_ID = 1L;

    IngredientCommandToIngredient ingredientCommandToIngredient;
    IngredientCommand ingredientCommand;

    @Before
    public void setUp() throws Exception {
        UnitOfMeasureCommand oum = new UnitOfMeasureCommand();
        oum.setId(UOM_ID);
        oum.setOum(UOM_KILOGRAMS);

        this.ingredientCommand = new IngredientCommand();
        this.ingredientCommand.setAmout(CMD_AMOUT);
        this.ingredientCommand.setDescription(CMD_DESCRIPTION);
        this.ingredientCommand.setId(CMD_ID);
        this.ingredientCommand.setUnitOfMeasureCommand(oum);

        ingredientCommandToIngredient = new IngredientCommandToIngredient();
    }
    @Test
    public void convertTest() {
        Ingredient ingredient = ingredientCommandToIngredient.convert(ingredientCommand);
        assertEquals(CMD_AMOUT, ingredient.getAmout());
        assertEquals(CMD_DESCRIPTION, ingredient.getDescription());
        assertEquals(new Long(CMD_ID), ingredient.getId());

        assertThat(ingredient.getUnitMeasure().getId(), is(UOM_ID));
        assertThat(ingredient.getUnitMeasure().getOum(), is(UOM_KILOGRAMS));

    }

    @Test
    public void convertEmptyObject() {
        assertNotNull(ingredientCommandToIngredient.convert(new IngredientCommand()));
    }

    @Test
    public void convertNull() {
        assertNull(ingredientCommandToIngredient.convert(null));

    }
}