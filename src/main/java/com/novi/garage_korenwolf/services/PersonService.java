package com.novi.garage_korenwolf.services;

import com.novi.garage_korenwolf.dto.PersonDto;
import com.novi.garage_korenwolf.mapper.PersonMapper;
import com.novi.garage_korenwolf.models.Person;
import com.novi.garage_korenwolf.repositories.CarRepository;
import com.novi.garage_korenwolf.repositories.PersonRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PersonService {

    private final PersonRepository personRepos;
    private final CarRepository carRepos;

    public PersonService(PersonRepository personRepos, CarRepository carRepos) {
        this.personRepos = personRepos;
        this.carRepos = carRepos;
    }

    public PersonDto createPerson(PersonDto personDto) {
        Person person = PersonMapper.toEntity(personDto);
        Person savedPerson = personRepos.save(person);
        return PersonMapper.toDto(savedPerson);
    }

    public PersonDto updatePerson(Long id, PersonDto updatedPersonDto) {
        Optional<Person> optionalPerson = personRepos.findById(id);

        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();

            // Update fields from DTO
            person.setFirstname(updatedPersonDto.getFirstname());
            person.setLastname(updatedPersonDto.getLastname());
            person.setDateOfBirth(updatedPersonDto.getDateOfBirth());
            person.setStreet(updatedPersonDto.getStreet());
            person.setHouseNumber(updatedPersonDto.getHouseNumber());
            person.setPostalCode(updatedPersonDto.getPostalCode());
            person.setTelephoneNumber(updatedPersonDto.getTelephoneNumber());
            person.setEmail(updatedPersonDto.getEmail());

            Person updated = personRepos.save(person);
            return PersonMapper.toDto(updated);
        } else {
            return null; // TODO: throw custom exception instead of returning null
        }
    }

    public List<PersonDto> getAllPersons() {
        return personRepos.findAll()
                .stream()
                .map(PersonMapper::toDto)
                .collect(Collectors.toList());
    }

    public boolean deletePerson(Long id) {
        if (personRepos.existsById(id)) {
            personRepos.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}



