package com.binio.recipes.converters;

import com.binio.recipes.commands.NotesCommand;
import com.binio.recipes.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand nc) {
        if(nc == null) {
            return null;
        }

        Notes notes = new Notes();
        nc.setId(nc.getId());
        nc.setRecipeNotes(nc.getRecipeNotes());

        return notes;
    }
}
