package com.novi.garage_korenwolf.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import java.util.List;

@Entity
public class Part extends JobItem {

    private int itemsInStock;

    @ElementCollection
    private List<String> suppliers;

    private String brand;

    private String category;

    // Getters & setters

    public int getItemsInStock() {
        return itemsInStock;
    }

    public void setItemsInStock(int itemsInStock) {
        this.itemsInStock = itemsInStock;
    }

    public List<String> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<String> suppliers) {
        this.suppliers = suppliers;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}