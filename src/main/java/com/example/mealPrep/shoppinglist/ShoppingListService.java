package com.example.mealPrep.shoppinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mealPrep.recipe.RecipeService;
import com.example.mealPrep.shoppinglist.ShoppingListRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final RecipeService recipeService;

    @Autowired
    public ShoppingListService(ShoppingListRepository shoppingListRepository, RecipeService recipeService) {
        this.shoppingListRepository = shoppingListRepository;
        this.recipeService = recipeService;
    }

    public List<ShoppingList> getShoppingList(Long[] recipeIds) {
        // this will be the list we return
        ArrayList<ShoppingList> shoppingLists = new ArrayList<>();

        // this contains the ingredients that we need
        List<String> items = recipeService.getIngredientsAll(recipeIds);

        // we can loop through the items for now and just set the quantity as one for all items?
        for (String item : items) {

            //use our repository select to check if item exists
            if (shoppingListRepository.getByItemName(item).isPresent()) {
                for (ShoppingList shoppingList : shoppingListRepository.findAll()) {
                    if (shoppingList.getItem().equals(item)) {
                        shoppingList.setQuantity(shoppingList.getQuantity() + 1);
                        shoppingListRepository.save(shoppingList);
                    }
                }
            }
            //else lets just add to the list as it doesn't exist
            else {
                shoppingLists.add(new ShoppingList(item, 1));
                shoppingListRepository.save(shoppingLists.get(shoppingLists.size() - 1));
            }
        }

        return shoppingListRepository.findAll();
    }
}
