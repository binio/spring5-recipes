package com.binio.recipes.bootstrap;

import com.binio.recipes.domain.Category;
import com.binio.recipes.domain.Difficulty;
import com.binio.recipes.domain.Ingredient;
import com.binio.recipes.domain.Recipe;
import com.binio.recipes.repositories.CategoryRepository;
import com.binio.recipes.repositories.RecipeRepository;
import com.binio.recipes.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public DevBootstrap(RecipeRepository recipeRepository,
                        CategoryRepository categoryRepository,
                        UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    private void initData() {

        Set<Category> categories1 = new HashSet<>();
        categories1.add(this.categoryRepository.findByDescription("Mexican").get());
        categories1.add(this.categoryRepository.findByDescription("Vegan").get());
        categories1.add(this.categoryRepository.findByDescription("Dip").get());

        Ingredient i1 = new Ingredient();
        i1.setAmout(new BigDecimal(2.0));
        i1.setDescription("Kosher salt");
        i1.setUnitMeasure(this.unitOfMeasureRepository.findByOum("Teaspoon").get());

        Ingredient i2 = new Ingredient();
        i2.setAmout(new BigDecimal(2.0));
        i2.setDescription("Ripe avocados");
        //i2.setUnitMeasure(this.unitOfMeasureRepository.findByOum("Teaspoon").get());

        Set<Ingredient> ingredients1 = new HashSet<>();
        ingredients1.add(i1);
        ingredients1.add(i2);

        Recipe recipe1 = new Recipe();
        recipe1.setCookTime(10);
        recipe1.setPrepTime(10);
        recipe1.setServings(5);
        recipe1.setDifficulty(Difficulty.EASY);
        recipe1.setCategories(categories1);
        recipe1.setDirections("directions");
        recipe1.setDescription("description");
        recipe1.setUrl("http://recipe.com");
        recipe1.setIngredients(ingredients1);

        i1.setRecipe(recipe1);
        i2.setRecipe(recipe1);

        recipeRepository.save(recipe1);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
