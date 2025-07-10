package com.novi.garage_korenwolf.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

public class PersonDto {

    public Long id;
    public String[] carIds;
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



