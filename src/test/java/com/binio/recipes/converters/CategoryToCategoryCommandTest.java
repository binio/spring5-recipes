package com.binio.recipes.converters;

import com.binio.recipes.commands.CategoryCommand;
import com.binio.recipes.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    public static final long CATEGORY_COMMAND_ID = 123L;
    public static final String CATEGORY_COMMAND_DESCRIPTION = "someDescription";

    Category category;
    CategoryToCategoryCommand categoryToCategoryCommand;

    @Before
    public void setUp() {
        category = new Category();
        category.setId(CATEGORY_COMMAND_ID);
        category.setDescription(CATEGORY_COMMAND_DESCRIPTION);
        categoryToCategoryCommand = new CategoryToCategoryCommand();

    }

    @Test
    public void convertTest() {
        CategoryCommand cc = categoryToCategoryCommand.convert(category);
        assertThat(cc.getDescription(), is(CATEGORY_COMMAND_DESCRIPTION));
        assertThat(cc.getId(), is(CATEGORY_COMMAND_ID));
    }

    @Test
    public void convertEmptyObject() {
        assertNotNull(categoryToCategoryCommand.convert(new Category()));
    }

    @Test
    public void convertNullObject() {
        assertNull(categoryToCategoryCommand.convert(null));
    }
}