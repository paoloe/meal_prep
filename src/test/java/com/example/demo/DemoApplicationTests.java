package com.example.demo;

import com.example.demo.recipe.Recipe;
import com.example.demo.recipe.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	//reference to recipe service
	private final RecipeService recipeService;

    DemoApplicationTests(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Test
	void contextLoads(){ //recipeId = [1,2,3]) {
			//recipeService.getIngredientsAll(recipeId);
	}

}
