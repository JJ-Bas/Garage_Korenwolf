package com.novi.garage_korenwolf.models;

import jakarta.persistence.*;

import java.time.LocalDate;


//TODO: id kan ook nummerbord zijn?

@Entity
@Table(name="cars")
public class Car {
    @Id
    @Column(name = "numberplate", nullable = false, unique = true)
    private String numberplate;
    @Column(name = "owner")
    private String ownerName;
    @Column(name = "registration_date")
    private LocalDate registrationDate;
    @Column(name = "build_year")
    private int buildYear;
    @Column(name = "color", length = 64)
    private String color;
    @Column(name = "fuel_type")
    private String fuelType;
    @Column(name = "brand_name")
    private String make;
    @Column(name = "model_name")
    private String model;


    //getters & setters


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    //getters






}
