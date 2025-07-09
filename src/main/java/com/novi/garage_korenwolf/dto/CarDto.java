package com.novi.garage_korenwolf.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
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
