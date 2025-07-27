package com.novi.garage_korenwolf.dto;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CarDto {



    @Size(max = 14)
    public String numberplate;

    public long[] personIds;

    public Long ownerId;
    @PastOrPresent
    public LocalDate registrationDate;

    public int buildYear;

    public String color;

    public String fuelType;

    public String make;

    public String model;

}
