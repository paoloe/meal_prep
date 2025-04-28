package com.example.demo.shoppinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/list") 
@CrossOrigin(origins = "http://localhost:3000")
public class ShoppingListController {

    //reference to recipe service
    private final ShoppingListService shoppingListService;

    //injecting ShoppingListService rather than having to instantiate a new class
    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @GetMapping("/getList/{recipeId}")
    public List<ShoppingList> getAllIngredients(@PathVariable Long[] recipeId) {
        return shoppingListService.getShoppingList(recipeId);
    }
}
