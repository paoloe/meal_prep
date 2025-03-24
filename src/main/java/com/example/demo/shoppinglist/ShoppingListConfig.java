package com.example.demo.shoppinglist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ShoppingListConfig {

    @Bean
    CommandLineRunner commandLineRunner2(ShoppingListRepository repository) {
        return args -> {
            ShoppingList Potato = new ShoppingList(
                    "Potato",
                    5
            );

            //invoke repository to save
            repository.saveAll(
                    List.of(Potato)
            );

        };
    }
}
