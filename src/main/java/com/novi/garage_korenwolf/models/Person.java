package com.novi.garage_korenwolf.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="persons")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name", length = 128)
    private String firstname;
    @Column(name = "last_name", length = 128)
    private String lastname;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "street_name", length = 128)
    private String street;
    @Column(name = "house_number")
    private int houseNumber;
    @Column(name= "postal_code")
    private String postalCode;
    @Column(name = "telephone_number")
    private int telephoneNumber;
    @Column(name = "email")
    private String email;

    //TODO foreign key: car & role & autopapieren uploaden



}
