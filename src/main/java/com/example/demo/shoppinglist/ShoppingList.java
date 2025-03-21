package com.example.demo.shoppinglist;

import jakarta.persistence.*;

@Entity
@Table
public class ShoppingList {

    @Id
    private String item;
    private Integer quantity;

    public ShoppingList(){}

    public ShoppingList(String item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "ShoppingList{" +
                ", item=" + item +
                ", quantity=" + quantity + '}';
    }

}
