package com.binio.recipes.controllers;

import com.binio.recipes.domain.Category;
import com.binio.recipes.domain.UnitOfMeasure;
import com.binio.recipes.repositories.CategoryRepository;
import com.binio.recipes.repositories.UnitOfMeasureRepository;
import com.binio.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/", "index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "index";
    }
}
