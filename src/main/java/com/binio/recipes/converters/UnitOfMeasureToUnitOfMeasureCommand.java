package com.binio.recipes.converters;

import com.binio.recipes.commands.UnitOfMeasureCommand;
import com.binio.recipes.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure,UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {
        if(unitOfMeasure == null) {
            return null;
        }

        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setOum(unitOfMeasure.getOum());
        unitOfMeasureCommand.setId(unitOfMeasure.getId());

        return unitOfMeasureCommand;
    }
}
