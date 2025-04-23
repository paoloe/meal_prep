package com.example.demo.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //annotation for the data access
public interface RecipeRepository
        extends JpaRepository<Recipe, Long> {

    @Query("SELECT s FROM Recipe s WHERE s.recipeName = ?1")
    Optional<Recipe> findRecipeByRecipeName(String recipeName);

    @Query("SELECT s.recipeIngredient FROM Recipe s WHERE s.recipeName = ?1")
    Optional<Recipe> findIngredientByRecipeName(String recipeIngredient);
}
