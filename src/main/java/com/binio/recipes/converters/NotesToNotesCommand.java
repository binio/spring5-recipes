package com.binio.recipes.converters;

import com.binio.recipes.commands.NotesCommand;
import com.binio.recipes.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes,NotesCommand> {

    @Synchronized
    @Nullable
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
