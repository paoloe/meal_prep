package com.example.demo.repository;

import com.example.demo.recipe.Recipe;
import com.example.demo.recipe.RecipeRepository;
import com.example.demo.recipe.RecipeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest //annotation so that the application recognises this as a test class
public class RecipeRepositoryTest {
    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    public void RecipeRepository_GetRecipe_findRecipeByRecipeName() {
            //Arrange: what do we need to get to perform the test? - Populate recipe
            Recipe Adobo = new Recipe(
                    "Adobo",
                    "Chicken,Garlic,Soy Sauce"
            );

            Recipe Lumpia = new Recipe(
                    "Lumpia",
                    "Chicken,Garlic,LumpiaWrapper"
            );

            //Act: Save the items
            recipeRepository.saveAll(
                List.of(Adobo, Lumpia));

            //Assert: check that it exists
            Optional<Recipe> recipe = recipeRepository.findRecipeByRecipeName("Adobo");
            Assertions.assertThat(recipe.get().getRecipeName()).isEqualTo("Adobo");
    }

}
