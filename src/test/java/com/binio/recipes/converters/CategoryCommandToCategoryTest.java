package com.binio.recipes.converters;

import com.binio.recipes.commands.CategoryCommand;
import com.binio.recipes.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    public static final long ID = 123L;
    public static final String DESCRIPTION = "description";

    CategoryToCategoryCommand converter;
    Category category;

    @Before
    public void setUp() {
        category = new Category();
        category.setId(ID);
        category.setDescription(DESCRIPTION);
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void convert() {
        CategoryCommand converter.convert(category);
    }
}