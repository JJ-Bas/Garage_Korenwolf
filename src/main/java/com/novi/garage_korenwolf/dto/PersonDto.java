package com.novi.garage_korenwolf.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class PersonDto {

    public Long id;

    public String firstname;
    public String lastname;
    public LocalDate dateOfBirth;
    public String street;
    public String houseNumber;
    public String postalCode;
    public int telephoneNumber;
    public String email;
}
