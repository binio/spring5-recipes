package com.binio.recipes.converters;

import com.binio.recipes.commands.CategoryCommand;
import com.binio.recipes.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {

    public static final Long ID = new Long(123L);
    public static final String DESCRIPTION = "description";

    CategoryCommandToCategory converter;
    CategoryCommand categoryCommand;

    @Before
    public void setUp() {
        categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID);
        categoryCommand.setDescription(DESCRIPTION);
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void convertTest() {
        Category c =  converter.convert(categoryCommand);
        assertEquals(ID, c.getId());
        assertEquals(DESCRIPTION, c.getDescription());
    }

    @Test
    public void convertEmptyObject() {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convertNullObject() {
        assertNull(converter.convert(null));
    }
}