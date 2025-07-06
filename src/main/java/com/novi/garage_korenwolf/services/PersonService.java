package com.novi.garage_korenwolf.services;

import com.novi.garage_korenwolf.dto.PersonDto;
import com.novi.garage_korenwolf.models.Person;
import com.novi.garage_korenwolf.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository repos;

    public PersonService(PersonRepository repos) {
        this.repos = repos;
    }

    public PersonDto createPerson(PersonDto personDto) {
        //PersonDto komt binnen en wordt opgeslagen als Person
        Person person = new Person();
        //Alle velden in de nieuw aangemaakt Person worden gevuld met info uit de personDTO
        person.setFirstname(personDto.firstname);
        person.setLastname(personDto.lastname);
        person.setDateOfBirth(personDto.dateOfBirth);
        person.setStreet(personDto.street);
        person.setHouseNumber(personDto.houseNumber);
        person.setPostalCode(personDto.postalCode);
        person.setTelephoneNumber(personDto.telephoneNumber);
        person.setEmail(personDto.email);
        //De aangemaakte person wordt opgeslagen in de repository en voegt het id toe aan Person
        repos.save(person);
        //id uit Person wordt toegevoegd aan de personDto
        personDto.id = person.getId();
        //de volledig gevulde personDto wordt teruggeven
        return personDto;
    }
}
