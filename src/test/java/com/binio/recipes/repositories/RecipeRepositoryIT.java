package com.binio.recipes.repositories;

import com.binio.recipes.domain.Recipe;
import com.binio.recipes.domain.UnitOfMeasure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RecipeRepositoryIT {

    @Autowired
    RecipeRepository recipeRepository;

    @Test
    public void testFindById() {
        Optional<Recipe> unit = recipeRepository.findById(2L);
        assertNotNull("Returned null Recipe", unit);



    }
}
