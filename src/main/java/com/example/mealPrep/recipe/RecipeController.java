package com.example.mealPrep.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/recipe")
@CrossOrigin(origins = "http://localhost:3000")
public class RecipeController {

    //reference to recipe service
    private final RecipeService recipeService;

    //injecting recipeService rather than having to instantiate a new class
    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/getAllRecipe/")
    public List<Recipe> getrecipes() {
        return recipeService.getRecipes();
    }

    @GetMapping("/getRecipe/{recipeId}")
    public List<String> getIngredients(@PathVariable Long recipeId) {
        return recipeService.getIngredients(recipeId);
    }

    @GetMapping("/getAllRecipe/{recipeId}")
    public List<String> getAllIngredients(@PathVariable Long[] recipeId) {
        return recipeService.getIngredientsAll(recipeId);
    }

    //Post is used when we want to add new resources to our system
    // in our case recipes
    @PostMapping(path = "/addNewRecipe/", consumes = "application/json")
    public void registerNewrecipe(@RequestBody Recipe recipe) {
        recipeService.addNewRecipe(recipe);
    }

    //call to delete recipe
    @DeleteMapping(path = "{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") Long recipeId) {
        recipeService.deleteRecipe(recipeId);
    }

    @PutMapping(path = "{recipeId}")
    public void updaterecipe(
            @PathVariable("recipeId") Long recipeId,
            @RequestParam(required = false) String recipeName,
            @RequestParam(required = false) String recipeIngredient) {
        recipeService.updateRecipe(recipeId, recipeName, recipeIngredient);
    }
}
