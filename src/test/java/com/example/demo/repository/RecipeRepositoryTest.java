package com.example.demo.repository;

import com.example.demo.recipe.Recipe;
import com.example.demo.recipe.RecipeRepository;
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

    private long id = 1;

    @Test
    public void RecipeRepository_GetRecipe_findRecipeByRecipeName() {
        //Arrange - what do we need to get to perform the test?
        Recipe Adobo = new Recipe(
                "Adobo",
                "Chicken,Garlic,Soy Sauce"
        );

        Recipe Lumpia = new Recipe(
                "Lumpia",
                "Chicken,Garlic,LumpiaWrapper"
        );

        //invoke repository to save
        recipeRepository.saveAll(
                List.of(Adobo, Lumpia)
        );
            // create an instance of recipe?
        //String recipe = recipeRepository.findRecipeByRecipeName("Adobo")
        Optional<Recipe> recipe = recipeRepository.findById(id);

        //Recipe recipe = recipeRepository.findById(id)
                //.orElseThrow(() -> new IllegalStateException("Recipe with name " + id + " does not exist"));

        //return List.of(recipe.getRecipeIngredient());


        //Act
        //System.out.println(recipe.get().getRecipeName());

        //Assert
        //Assertions.assertThat(recipe).isNotNull();
        Assertions.assertThat(recipe.get().getRecipeName()).isEqualTo("Adobo");
    }

}
