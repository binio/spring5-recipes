package com.binio.recipes.converters;

import com.binio.recipes.commands.UnitOfMeasureCommand;
import com.binio.recipes.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;

public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure,UnitOfMeasureCommand> {

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
