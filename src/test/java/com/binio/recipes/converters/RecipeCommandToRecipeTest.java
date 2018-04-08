package com.binio.recipes.converters;

import com.binio.recipes.commands.*;
import com.binio.recipes.domain.Difficulty;
import com.binio.recipes.domain.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class RecipeCommandToRecipeTest {

    public static final long NOTES_ID = 123L;
    public static final String NOTES_NOTE = "Note";
    public static final long COMMAND_ID = 123L;
    public static final Difficulty COMMAND_DIFFICULTY = Difficulty.EASY;
    public static final int COMMAND_COOK_TIME = 123;
    public static final String COMMAND_DESCRIPTION = "description";
    public static final String COMMAND_DIRECTION = "direction";
    public static final int COMMAND_PREP_TIME = 100;
    public static final int COMMAND_SERVINGS = 2;
    public static final String COMMAND_SOURCE = "source";
    public static final String COMMAND_URL = "url";
    public static final long CATEGORY_ID = 123L;
    public static final String CATEGORY_DESCRIPTION = "categoryDescription";
    public static final long INGREDIENT_ID = 123L;
    public static final BigDecimal INGREDIENT_AMOUT = new BigDecimal(123);
    public static final String INGREDIENT_DESCRIPTION = "ingredientDescription";
    public static final long UNIT_OF_MESURE_ID = 123L;
    public static final String UNIT_OF_MESURE_NAME = "kilogram";

    RecipeCommandToRecipe converter = new RecipeCommandToRecipe(new CategoryCommandToCategory(), new IngredientCommandToIngredient(),new NotesCommandToNotes());
    RecipeCommand command;

    @Before
    public void setUp() {

        command = new RecipeCommand();
        command.setId(COMMAND_ID);
        command.setDifficulty(COMMAND_DIFFICULTY);
        command.setCookTime(COMMAND_COOK_TIME);
        command.setDescription(COMMAND_DESCRIPTION);
        command.setDirections(COMMAND_DIRECTION);
        command.setNotes(getNotesCommand());
        command.setPrepTime(COMMAND_PREP_TIME);
        command.setServings(COMMAND_SERVINGS);
        command.setCategories(getCategories());
        command.setIngredients(getIngredients());
        command.setSource(COMMAND_SOURCE);
        command.setUrl(COMMAND_URL);

    }

    @Test
    public void testConversion() {
        Recipe recipe = converter.convert(command);
        assertThat(recipe.getId(), is(COMMAND_ID));
        assertThat(recipe.getDescription(), is(COMMAND_DESCRIPTION));
        assertThat(recipe.getCookTime(), is(COMMAND_COOK_TIME));

    }

    private NotesCommand getNotesCommand() {
        NotesCommand notesCmd = new NotesCommand();
        notesCmd.setId(NOTES_ID);
        notesCmd.setRecipeNotes(NOTES_NOTE);
        return notesCmd;
    }

    private Set<CategoryCommand> getCategories() {
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(CATEGORY_ID);
        categoryCommand.setDescription(CATEGORY_DESCRIPTION);

        Set<CategoryCommand> set = new HashSet<>();
        set.add(categoryCommand);

        return set;
    }

    private Set<IngredientCommand> getIngredients() {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(INGREDIENT_ID);
        ingredientCommand.setUnitOfMeasureCommand(getUnitOfMeasure());
        ingredientCommand.setAmout(INGREDIENT_AMOUT);
        ingredientCommand.setDescription(INGREDIENT_DESCRIPTION);

        Set<IngredientCommand> set = new HashSet<>();
        set.add(ingredientCommand);
        return set;
    }

    private UnitOfMeasureCommand getUnitOfMeasure() {
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(UNIT_OF_MESURE_ID);
        command.setOum(UNIT_OF_MESURE_NAME);
        return command;
    }

}