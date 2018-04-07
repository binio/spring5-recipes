package com.binio.recipes.converters;

import com.binio.recipes.commands.NotesCommand;
import com.binio.recipes.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand nc) {
        if(nc == null) {
            return null;
        }

        Notes notes = new Notes();
        notes.setId(nc.getId());
        notes.setRecipeNotes(nc.getRecipeNotes());

        return notes;
    }
}
