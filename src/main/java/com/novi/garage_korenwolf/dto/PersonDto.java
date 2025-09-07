package com.novi.garage_korenwolf.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class PersonDto {

    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String street;
    private String houseNumber;
    private String postalCode;
    private int telephoneNumber;
    private String email;

    //relations
    private List<Long> carPaperIds;
    private Set<String> carNumberplates;

    //getters & setters

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

    public List<Long> getCarPaperIds() {
        return carPaperIds;
    }

    public void setCarPaperIds(List<Long> carPaperIds) {
        this.carPaperIds = carPaperIds;
    }

    public Set<String> getCarNumberplates() {
        return carNumberplates;
    }

    public void setCarNumberplates(Set<String> carNumberplates) {
        this.carNumberplates = carNumberplates;
    }
}



