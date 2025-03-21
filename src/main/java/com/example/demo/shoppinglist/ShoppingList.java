package com.example.demo.shoppinglist;

import jakarta.persistence.*;

@Entity
@Table
public class ShoppingList {
    @Id
    @SequenceGenerator(
            name = "shoppingList_sequence",
            sequenceName = "shoppingList_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shoppingList_sequence"
    )

    private Long id;
    private String item;
    private Integer quantity;

    public ShoppingList(){}

    public ShoppingList(String item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public ShoppingList(Long id, String item, Integer quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "ShoppingList{"
                + "id=" + id +
                ", item=" + item +
                ", quantity=" + quantity + '}';
    }
}
