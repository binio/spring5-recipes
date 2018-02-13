package com.binio.recipes.controllers;

import com.binio.recipes.domain.Category;
import com.binio.recipes.domain.UnitOfMeasure;
import com.binio.recipes.repositories.CategoryRepository;
import com.binio.recipes.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository uomRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository uomRepository) {
        this.categoryRepository = categoryRepository;
        this.uomRepository = uomRepository;
    }

    @RequestMapping({"/", "index"})
    public String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> uomOptional = uomRepository.findByOum("Teaspoon");
        System.out.println("category: " + categoryOptional.get().getId());
        System.out.println("unitOfMeasure: " + uomOptional.get().getId());
        return "index";
    }
}
