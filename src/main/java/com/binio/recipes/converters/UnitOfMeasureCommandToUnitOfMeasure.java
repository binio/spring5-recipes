package com.binio.recipes.converters;

import com.binio.recipes.commands.UnitOfMeasureCommand;
import com.binio.recipes.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure  implements Converter<UnitOfMeasureCommand,UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMeasureCommand) {
        if(unitOfMeasureCommand == null) {
            return null;
        }

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setOum(unitOfMeasure.getOum());
        unitOfMeasure.setId(unitOfMeasure.getId());

        return unitOfMeasure;
    }
}
