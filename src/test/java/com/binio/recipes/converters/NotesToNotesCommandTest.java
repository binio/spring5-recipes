package com.binio.recipes.converters;

import com.binio.recipes.commands.NotesCommand;
import com.binio.recipes.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NotesToNotesCommandTest {

    public static final long NOTES_ID = 123L;
    public static final String NOTES_NOTE = "note notes";
    NotesToNotesCommand notesToNotesCommand = new NotesToNotesCommand();
    Notes notes;

    @Before
    public void setUp() {
        notes = new Notes();
        notes.setId(NOTES_ID);
        notes.setRecipeNotes(NOTES_NOTE);
    }

    @Test
    public void testConversion() {
        NotesCommand nc = notesToNotesCommand.convert(notes);
        assertThat(nc.getId(), is(NOTES_ID));
        assertThat(nc.getRecipeNotes(), is(NOTES_NOTE));
    }

    @Test
    public void testEmptyObject() {
        NotesCommand nc = notesToNotesCommand.convert(new Notes());
        assertNotNull(nc);

    }

    @Test
    public void  testNullObject() {
        NotesCommand nc = notesToNotesCommand.convert(null);
        assertNull(nc);

    }
}