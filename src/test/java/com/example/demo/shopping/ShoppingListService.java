package com.example.demo.shopping;

import com.example.demo.shoppinglist.ShoppingList;
import com.example.demo.shoppinglist.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
