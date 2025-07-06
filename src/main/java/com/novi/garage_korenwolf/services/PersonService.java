package com.novi.garage_korenwolf.services;

import com.novi.garage_korenwolf.dto.PersonDto;
import com.novi.garage_korenwolf.models.Person;
import com.novi.garage_korenwolf.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public PersonDto updatePerson(Long id, PersonDto updatedPersonDto) {
        Optional<Person> optionalPerson = repos.findById(id);

        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();

            person.setFirstname(updatedPersonDto.firstname);
            person.setLastname(updatedPersonDto.lastname);
            person.setDateOfBirth(updatedPersonDto.dateOfBirth);
            person.setStreet(updatedPersonDto.street);
            person.setHouseNumber(updatedPersonDto.houseNumber);
            person.setPostalCode(updatedPersonDto.postalCode);
            person.setTelephoneNumber(updatedPersonDto.telephoneNumber);
            person.setEmail(updatedPersonDto.email);

            Person updated = repos.save(person);

            PersonDto resultDto = new PersonDto();
            resultDto.id = updated.getId();
            resultDto.firstname = updated.getFirstname();
            resultDto.lastname = updated.getLastname();
            resultDto.dateOfBirth = updated.getDateOfBirth();
            resultDto.street = updated.getStreet();
            resultDto.houseNumber = updated.getHouseNumber();
            resultDto.postalCode = updated.getPostalCode();
            resultDto.telephoneNumber = updated.getTelephoneNumber();
            resultDto.email = updated.getEmail();

            return resultDto;
        } else {
            return null;
        }
    }


    public List<PersonDto> getAllPersons() {
        return repos.findAll()
                .stream()
                .map(person -> {
                    PersonDto dto = new PersonDto();
                    dto.id = person.getId();
                    dto.firstname = person.getFirstname();
                    dto.lastname = person.getLastname();
                    dto.dateOfBirth = person.getDateOfBirth();
                    dto.street = person.getStreet();
                    dto.houseNumber = person.getHouseNumber();
                    dto.postalCode = person.getPostalCode();
                    dto.telephoneNumber = person.getTelephoneNumber();
                    dto.email = person.getEmail();
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public boolean deletePerson(Long id) {
        if (repos.existsById(id)) {
            repos.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
