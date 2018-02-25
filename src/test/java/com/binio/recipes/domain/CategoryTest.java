package com.binio.recipes.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    private Category category;

    @Before
    public void setup(){
        category = new Category();
        category.setDescription("Mexican");
    }
    @Test
    public void setDescription() {
        assertEquals("Mexican",category.getDescription());
    }
}