package com.novi.garage_korenwolf.models;

import jakarta.persistence.*;

import java.time.LocalDate;


//TODO: id kan ook nummerbord zijn?

@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "owner")
    private String ownerName;
    @Column(name = "numberplate")
    private String numberplate;
    @Column(name = "registration_date")
    private LocalDate registrationDate;
    @Column(name = "build_year")
    private int buildYear;
    @Column(name = "color", length = 64)
    private String color;
    @Column(name = "fuel_type")
    private String fuelType;
    @Column(name = "brand_name")
    private String Make;
    @Column(name = "model_name")
    private String Model;

    //getters






}
