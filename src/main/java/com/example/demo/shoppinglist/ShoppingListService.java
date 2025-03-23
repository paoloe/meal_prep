package com.example.demo.shoppinglist;

import com.example.demo.recipe.RecipeService;
import com.example.demo.shoppinglist.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<ShoppingList> findAll() {
        return shoppingListRepository.findAll();
    }

    public List<ShoppingList> getShoppingList(Long[] recipeIds) {
        // this will be the list we return
        ArrayList<ShoppingList> shoppingLists = new ArrayList<>();

        // this contains the ingredients that we need
        List<String> items = recipeService.getIngredientsAll(recipeIds);

        // we can loop through the items for now and just set the quantity as one for all items?
        for (String item : items) {

            //if we find this item in the table lets add to qty
            if (shoppingListRepository.getByItemName(item).isPresent()) {
                for (ShoppingList shoppingList : shoppingListRepository.findAll()) {
                    if (shoppingList.getItem().equals(item)) {
                        shoppingList.setQuantity(shoppingList.getQuantity() + 1);
                    }
                }
            } else {
                shoppingLists.add(new ShoppingList(item, 1));
            }

            //append
            shoppingListRepository.saveAll(shoppingLists);
        }

        return shoppingLists;
    }
}
