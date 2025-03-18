package com.example.demo.repository;

import com.example.demo.recipe.Recipe;
import com.example.demo.recipe.RecipeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest //annotation so that the application recognises this as a test class
public class RecipeRepositoryTest {
    @Autowired
    private RecipeRepository recipeRepository;

    private long id = 1;

    @Test
    public void RecipeRepository_GetRecipe_findRecipeByRecipeName() {
        //Arrange - what do we need to get to perform the test?
            // create an instance of recipe?
        //String recipe = recipeRepository.findRecipeByRecipeName("Adobo")
        Optional<Recipe> recipe = recipeRepository.findById(id);

        //Act
        System.out.println(recipe.get().getRecipeName());

        //Assert
        Assertions.assertThat(recipe).isNotNull();

    }

}
