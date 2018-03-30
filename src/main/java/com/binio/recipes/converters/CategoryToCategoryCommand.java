package com.binio.recipes.converters;

import com.binio.recipes.commands.CategoryCommand;
import com.binio.recipes.domain.Category;
import org.springframework.core.convert.converter.Converter;

public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand>{


    @Override
    public CategoryCommand convert(Category category) {
        if (category == null) {
            return null;
        }

        CategoryCommand command = new CategoryCommand();
        command.setId(category.getId());
        command.setDescription(category.getDescription());

        return command;
    }
}