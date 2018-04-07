package com.binio.recipes.converters;

import com.binio.recipes.commands.UnitOfMeasureCommand;
import com.binio.recipes.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final long COMMAND_ID = 123L;
    public static final String COMMAND_OUM = "kilogram";
    UnitOfMeasureCommandToUnitOfMeasure converter = new UnitOfMeasureCommandToUnitOfMeasure();
    UnitOfMeasureCommand command;

    @Before
    public void setUp() {
        command = new UnitOfMeasureCommand();
        command.setId(COMMAND_ID);
        command.setOum(COMMAND_OUM);
    }

    @Test
    public void testConversion() {
        UnitOfMeasure uom = converter.convert(command);
        assertThat(uom.getId(), is(COMMAND_ID));
        assertThat(uom.getOum(),is(COMMAND_OUM));
    }

    @Test
    public void testEmptyObject(){
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void testNullObject(){
        assertNull(converter.convert(null));
    }
}