package com.example.mealPrep.recipe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class RecipeConfig {

    @Bean
    CommandLineRunner commandLineRunner(RecipeRepository repository) {
        return args -> {
            Recipe Adobo = new Recipe(
                    "Adobo",
                    "Chicken,Garlic,Soy Sauce"
            );

            Recipe Lumpia = new Recipe(
                "Lumpia",
                "Chicken,Garlic,LumpiaWrapper"
            );

            Recipe Caldereta = new Recipe(
                "Caldereta",
                "Beef,Garlic,Tomato"
            );

            //invoke repository to save
            repository.saveAll(
                    List.of(Adobo, Lumpia, Caldereta)
            );

        };
    }

}
