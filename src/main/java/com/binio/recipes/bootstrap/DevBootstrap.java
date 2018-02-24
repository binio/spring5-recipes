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

        Set<Ingredient> ingredients1 = new HashSet<>();

        Recipe recipe1 = new Recipe();
        recipe1.setCookTime(10);
        recipe1.setPrepTime(10);
        recipe1.setServings(5);
        recipe1.setDifficulty(Difficulty.EASY);
        recipe1.setCategories(categories1);
        recipe1.setDirections("" +
                "Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon." +
                "Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste." +
                "Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving." +
                "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.");
        recipe1.setDescription("How to Make Perfect Guacamole");
        recipe1.setUrl("http://recipe.com");


        Ingredient i1 = new Ingredient(
                "Kosher Salt",
                new BigDecimal(0.5),
                this.unitOfMeasureRepository.findByOum("Teaspoon").get(),
                recipe1);
        Ingredient i2 = new Ingredient(
                "Avocado",
                new BigDecimal(2.0),
                this.unitOfMeasureRepository.findByOum("Teaspoon").get(),
                recipe1);
        Ingredient i3 = new Ingredient(
                "Lemon juice or lime juice",
                new BigDecimal(0.5),
                this.unitOfMeasureRepository.findByOum("Tablespoon").get(),
                recipe1);
        Ingredient i4 = new Ingredient(
                "Lemon juice or lime juice",
                new BigDecimal(0.5),
                this.unitOfMeasureRepository.findByOum("Tablespoon").get(),
                recipe1);
        Ingredient i5 = new Ingredient(
                "Minced red onion or thinly sliced green onion",
                new BigDecimal(2.0),
                this.unitOfMeasureRepository.findByOum("Tablespoon").get(),
                recipe1);
        Ingredient i6 = new Ingredient(
                "Serrano chiles, stems and seeds removed, minced",
                new BigDecimal(2.0),
                this.unitOfMeasureRepository.findByOum("Tablespoon").get(),
                recipe1);
        Ingredient i7 = new Ingredient(
                "Cilantro (leaves and tender stems), finely chopped",
                new BigDecimal(2.0),
                this.unitOfMeasureRepository.findByOum("Tablespoon").get(),
                recipe1);
        Ingredient i8 = new Ingredient(
                "A dash of freshly grated black pepper",
                new BigDecimal(2.0),
                this.unitOfMeasureRepository.findByOum("Tablespoon").get(),
                recipe1);
        Ingredient i9 = new Ingredient(
                "Ripe tomato, seeds and pulp removed, chopped",
                new BigDecimal(0.5),
                this.unitOfMeasureRepository.findByOum("Tablespoon").get(),
                recipe1);
        ingredients1.add(i1);
        ingredients1.add(i2);
        ingredients1.add(i3);
        ingredients1.add(i4);
        ingredients1.add(i5);
        ingredients1.add(i6);
        ingredients1.add(i7);
        ingredients1.add(i8);
        ingredients1.add(i9);


        recipe1.setIngredients(ingredients1);
        recipeRepository.save(recipe1);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
