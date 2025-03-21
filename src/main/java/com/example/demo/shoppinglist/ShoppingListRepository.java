package com.example.demo.shoppinglist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingListRepository
        extends JpaRepository<ShoppingList, Long> {

    @Query("SELECT s FROM ShoppingList s WHERE s = ?1")
    Optional<ShoppingList> findItemByName(String itemName);

}
