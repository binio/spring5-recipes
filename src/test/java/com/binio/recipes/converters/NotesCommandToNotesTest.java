package com.binio.recipes.converters;

import com.binio.recipes.commands.NotesCommand;
import com.binio.recipes.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NotesCommandToNotesTest {

    public static final String RECIPE_NOTES = "recipeNotes";
    public static final long NOTES_COMMAND_ID = 123L;
    NotesCommandToNotes notesCommandToNotes = new NotesCommandToNotes();
    NotesCommand notesCommand;

    @Before
    public void setUp() {
    notesCommand = new NotesCommand();
    notesCommand.setRecipeNotes(RECIPE_NOTES);
    notesCommand.setId(NOTES_COMMAND_ID);
    }

    @Test
    public void testConversion() {
        Notes notes = notesCommandToNotes.convert(notesCommand);
        assertThat(notes.getId(), is(NOTES_COMMAND_ID));
        assertThat(notes.getRecipeNotes(), is(RECIPE_NOTES));
    }

    @Test
    public void convertEmptyObject() {
        assertNotNull(notesCommandToNotes.convert(new NotesCommand()));
    }

    @Test
    public void convertNull() {
        assertNull(notesCommandToNotes.convert(null));

    }
}