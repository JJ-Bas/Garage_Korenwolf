package com.novi.garage_korenwolf.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue
    private Long id;


    @ManyToMany(mappedBy = "personSet")
    private Set<Car> carsSet;

    @Column(name = "first_name", length = 128)
    private String firstname;
    @Column(name = "last_name", length = 128)
    private String lastname;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "street_name", length = 128)
    private String street;
    @Column(name = "house_number")
    private String houseNumber;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "telephone_number")
    private int telephoneNumber;
    @Column(name = "email")
    private String email;

    //getters & setters


    public Set<Car> getCarsSet() {
        return carsSet;
    }

    public void setCarsSet(Set<Car> carsSet) {
        this.carsSet = carsSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//TODO foreign key: car & role & autopapieren uploaden


}
