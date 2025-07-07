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


    @NotBlank
    @Size(max = 14)
    public String numberplate;
    @NotBlank
    public Long ownerId;
    @PastOrPresent
    public LocalDate registrationDate;
    @Past
    public int buildYear;
    @NotBlank
    public String color;
    @NotBlank
    public String fuelType;
    @NotBlank
    public String make;
    @NotBlank
    public String model;

}
