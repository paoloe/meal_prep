package com.example.demo.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.mealPrep.shoppinglist.ShoppingList;
import com.example.mealPrep.shoppinglist.ShoppingListRepository;

@DataJpaTest
public class ShoppingListService {

    // loosely couple our repository class
    @Autowired
    private ShoppingListRepository shoppingListRepository;

    public void ShoppingListRepository_SaveShoppingList_ShoppingList() {
        ShoppingList shoppingList1 = new ShoppingList(
                "Chicken",
                2
        );

        shoppingListRepository.save(shoppingList1);
    }

}
