package com.binio.recipes.converters;

import com.binio.recipes.commands.CategoryCommand;
import com.binio.recipes.commands.IngredientCommand;
import com.binio.recipes.commands.NotesCommand;
import com.binio.recipes.commands.RecipeCommand;
import com.binio.recipes.domain.Difficulty;
import org.junit.Before;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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
    RecipeCommandToRecipe converter = new RecipeCommandToRecipe();
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

    private NotesCommand getNotesCommand() {
        NotesCommand notesCmd = new NotesCommand();
        notesCmd.setId(NOTES_ID);
        notesCmd.setRecipeNotes(NOTES_NOTE);
        return notesCmd;
    }

    private Set<CategoryCommand> getCategories() {
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(123L);
        categoryCommand.setDescription("categoryDescription");

        Set<CategoryCommand> set = new HashSet<>();
        set.add(categoryCommand);

        return set;
    }

    private Set<IngredientCommand> getIngredients() {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(123L);
        ingredientCommand.setUnitOfMeasureCommand(getUnitOfMeasure());
        ingredientCommand.setAmout(new BigDecimal(123));
        ingredientCommand.setDescription("ingredientDescription");

        Set<IngredientCommand> set = new HashSet<>();
        set.add(ingredientCommand);
        return set;
    }

}