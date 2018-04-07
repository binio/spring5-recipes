package com.binio.recipes.converters;

import com.binio.recipes.commands.UnitOfMeasureCommand;
import com.binio.recipes.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final long COMMAND_ID = 123L;
    public static final String COMMAND_OUM = "kilogram";
    UnitOfMeasureToUnitOfMeasureCommand converter = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasure domainObj;

    @Before
    public void setUp() {
        domainObj = new UnitOfMeasure();
        domainObj.setId(COMMAND_ID);
        domainObj.setOum(COMMAND_OUM);
    }

    @Test
    public void testConversion() {
        UnitOfMeasureCommand uom = converter.convert(domainObj);
        assertThat(uom.getId(), is(COMMAND_ID));
        assertThat(uom.getOum(),is(COMMAND_OUM));
    }

    @Test
    public void testEmptyObject(){
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void testNullObject(){
        assertNull(converter.convert(null));
    }
}