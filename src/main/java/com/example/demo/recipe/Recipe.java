package com.example.demo.recipe;

import jakarta.persistence.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Entity //this is for hibernate
@Table
public class Recipe {
    @Id
    @SequenceGenerator(
            //is this creating the id?
            name = "recipe_sequence",
            sequenceName = "recipe_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            //adding comments so we can commit as this is now successfully
            //connecting to our database
            strategy = GenerationType.SEQUENCE,
            generator = "recipe_sequence"
    )
    private Long id;
    private String recipeName;
    private String recipeIngredient;

    public Recipe() {}

    public Recipe(Long id,
                  String recipeName,
                  String recipeIngredient) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeIngredient = recipeIngredient;
    }

    public Recipe(String recipeName,
                  String recipeIngredient) {
        this.recipeName = recipeName;
        this.recipeIngredient = recipeIngredient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeIngredient() {
        return recipeIngredient;
    }

    public void setRecipeIngredient(String recipeIngredient) {
        this.recipeIngredient = recipeIngredient;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", Recipe Name='" + recipeName + '\'' +
                ", Recipe Ingridients='" + recipeIngredient +
                '}';
    }
}
