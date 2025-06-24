package com.novi.garage_korenwolf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="persons")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String street;
    private int houseNumber;
    private String postalCode;
    private int telephoneNumber;
    private String email;

    //TODO foreign key: car & role & autopapieren uploaden



}
