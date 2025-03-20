package com.example.demo.recipe;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired //loosely coupling again here... nice
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipes() {
        return recipeRepository.findAll(); //return list
    }

    //get ingredient just for one recipe
    public List<String> getIngredients(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new IllegalStateException("Recipe with name " + recipeId + " does not exist"));

        return List.of(recipe.getRecipeIngredient());
    }


//    [
//        "Chicken,Garlic,Soy Sauce",
//        "Chicken,Garlic,LumpiaWrapper"
//    ]

    //get all ingredients for a given list of ID's
    public List<String> getIngredientsAll(Long[] recipeIds) {
        List<String> ingredients = new ArrayList<>();
        List<String> ingredientsAll = new ArrayList<>();

        for (Long recipeId : recipeIds) {
            Optional<Recipe> recipe = recipeRepository.findById(recipeId);
            if (recipe.isPresent()) {
                ingredients.add(recipe.get().getRecipeIngredient());
            }
        }

        //trying to split the contents of each recipe ingredients list...
        for (String ingredient : ingredients) {
            ingredientsAll= List.of(ingredient.split(","));
        }

        return ingredientsAll;
    }

    public void addNewRecipe(Recipe recipe) {
        Optional<Recipe> RecipeOptional = recipeRepository.
                findRecipeByRecipeName(recipe.getRecipeName());
        if (RecipeOptional.isPresent()){
            throw new IllegalStateException("Recipe already exists");
        }
        recipeRepository.save(recipe);
    }

    public void addNewIngredient(Recipe recipe, String ingredient) {
        Optional<Recipe> RecipeOptional = recipeRepository.findRecipeByRecipeName(recipe.getRecipeName());
        if (RecipeOptional.isPresent()){
            recipe.setRecipeIngredient(ingredient);
        }
    }

    //delete Recipe
    public void deleteRecipe(Long RecipeId) {
        boolean exists = recipeRepository.existsById(RecipeId);
        //lets first check if it exists
        if (!exists){
            throw new IllegalStateException("Recipe with id " + RecipeId + " does not exist");
        }
        recipeRepository.deleteById(RecipeId);
    }

    //PUT - update an existing record
    @Transactional // this annotation puts the entity into a managed state
    public void updateRecipe(Long RecipeId,
                              String recipeName,
                              String recipeIngredients) {
        Recipe recipe = recipeRepository.findById(RecipeId).
                orElseThrow(() -> new IllegalStateException("Recipe with id " + RecipeId + " does not exist"));

        // validate name is not blank, length is > 0 and name values are not the same
        if (recipeName != null && recipeName.length() > 0 && !Objects.equals(recipe.getRecipeName(), recipeName)){
            recipe.setRecipeName(recipeName);
        }

        if (recipeIngredients != null && recipeIngredients.length() > 0 && !Objects.equals(recipe.getRecipeIngredient(), recipeIngredients)) {
            Optional<Recipe> studentOptional = recipeRepository
                    .findRecipeByRecipeName(recipeName);
            if (studentOptional.isPresent()) {
                recipe.setRecipeIngredient(recipeIngredients);
            }
        }
    }
}
