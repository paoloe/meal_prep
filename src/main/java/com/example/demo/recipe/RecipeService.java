package com.example.demo.recipe;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void addNewRecipe(Recipe recipe) {
        Optional<Recipe> RecipeOptional = recipeRepository.
                findRecipeByRecipeName(recipe.getRecipeName());
        if (RecipeOptional.isPresent()){
            throw new IllegalStateException("Recipe already exists");
        }
        recipeRepository.save(recipe);
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

    }
}
