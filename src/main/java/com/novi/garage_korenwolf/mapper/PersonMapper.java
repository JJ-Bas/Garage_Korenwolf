package com.novi.garage_korenwolf.mapper;

import com.novi.garage_korenwolf.dto.PersonDto;
import com.novi.garage_korenwolf.models.CarPaper;
import com.novi.garage_korenwolf.models.Person;
import com.novi.garage_korenwolf.models.Car;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonMapper {
    public static PersonDto toDto(Person person) {
        if (person == null) {
            return null;
        }

        PersonDto dto = new PersonDto();
        dto.setId(person.getId());
        dto.setFirstname(person.getFirstname());
        dto.setLastname(person.getLastname());
        dto.setDateOfBirth(person.getDateOfBirth());
        dto.setStreet(person.getStreet());
        dto.setHouseNumber(person.getHouseNumber());
        dto.setPostalCode(person.getPostalCode());
        dto.setTelephoneNumber(person.getTelephoneNumber());
        dto.setEmail(person.getEmail());

        List<Long> carPaperIds = person.getCarPapers().stream()
                .map(CarPaper::getId)
                .collect(Collectors.toList());
        dto.setCarPaperIds(carPaperIds);

        Set<String> carNumberplates = person.getCarsSet().stream()
                .map(Car::getNumberplate)
                .collect(Collectors.toSet());
        dto.setCarNumberplates(carNumberplates);

        return dto;
    }

    public static Person toEntity(PersonDto dto) {
        if (dto == null) {
            return null;
        }

        Person person = new Person();
        person.setId(dto.getId());
        person.setFirstname(dto.getFirstname());
        person.setLastname(dto.getLastname());
        person.setDateOfBirth(dto.getDateOfBirth());
        person.setStreet(dto.getStreet());
        person.setHouseNumber(dto.getHouseNumber());
        person.setPostalCode(dto.getPostalCode());
        person.setTelephoneNumber(dto.getTelephoneNumber());
        person.setEmail(dto.getEmail());

        return person;
    }

}
