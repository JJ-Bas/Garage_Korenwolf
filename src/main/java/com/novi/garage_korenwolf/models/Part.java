package com.novi.garage_korenwolf.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
@DiscriminatorValue("PART")
public class Part extends JobItem{

    private int ItemsInStock;
    private List<String> Suppliers;
    private String Brand;
    private String categorie;


    // getter & setters

    public int getItemsInStock() {
        return ItemsInStock;
    }

    public void setItemsInStock(int itemsInStock) {
        ItemsInStock = itemsInStock;
    }

    public List<String> getSuppliers() {
        return Suppliers;
    }

    public void setSuppliers(List<String> suppliers) {
        Suppliers = suppliers;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
