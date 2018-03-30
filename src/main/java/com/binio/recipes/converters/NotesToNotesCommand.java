package com.binio.recipes.converters;

import com.binio.recipes.commands.NotesCommand;
import com.binio.recipes.domain.Notes;
import org.springframework.core.convert.converter.Converter;

public class NotesToNotesCommand implements Converter<Notes,NotesCommand> {

    @Override
    public NotesCommand convert(Notes notes) {
        if(notes == null) {
            return null;
        }

        NotesCommand nc = new NotesCommand();
        nc.setId(notes.getId());
        nc.setRecipeNotes(notes.getRecipeNotes());

        return  nc;
    }
}
