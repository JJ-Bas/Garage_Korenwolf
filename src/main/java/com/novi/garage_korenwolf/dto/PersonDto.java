package com.novi.garage_korenwolf.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Set;

public class PersonDto {

    public Long id;
    public String[] roles;
    public Set<CarDto> carIds;
    @NotBlank
    public String firstname;
    @NotBlank
    public String lastname;
    @Past
    public LocalDate dateOfBirth;
    public String street;
    @Size(min=1, max=10)
    public String houseNumber;
    public String postalCode;
    public int telephoneNumber;
    @Email
    public String email;

}



