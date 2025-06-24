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

    private String ownerName;
    private String numberplate;
    private LocalDate registrationDate;
    private int buildYear;
    private String color;
    private String fuelType;
    private String Make;
    private String Model;

    //getters






}
