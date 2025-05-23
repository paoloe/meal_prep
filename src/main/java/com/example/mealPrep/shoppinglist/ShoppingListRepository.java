package com.example.mealPrep.shoppinglist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //annotation for the data access
public interface ShoppingListRepository
        extends JpaRepository<ShoppingList, String> {

    //Select the shopping_list.itemName if it exists
    @Query("SELECT s FROM ShoppingList s WHERE s.item = :itemName")
    Optional<ShoppingList> getByItemName(@Param("itemName") String itemName);

}
