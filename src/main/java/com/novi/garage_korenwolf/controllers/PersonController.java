package com.novi.garage_korenwolf.controllers;

import com.novi.garage_korenwolf.dto.PersonDto;
import com.novi.garage_korenwolf.models.Person;
import com.novi.garage_korenwolf.repositories.PersonRepository;
import com.novi.garage_korenwolf.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {


    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getPersons() {
        List<PersonDto> persons = service.getAllPersons();
        return ResponseEntity.ok(persons);
    }

    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {
        service.createPerson(personDto);

        //pakt uri van de huidige request en plakt daar de Id van de nieuw aangemaakt person aan vast.
        //vervolgens word in de return de nieuwe person opgevraagd en meegegeven

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + personDto.id).toUriString());
        return ResponseEntity.created(uri).body(personDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable Long id, @RequestBody PersonDto updatedPersonDto) {

        PersonDto updatedDto = service.updatePerson(id, updatedPersonDto);
        if (updatedDto != null) {
            return ResponseEntity.ok(updatedDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        boolean deleted = service.deletePerson(id);
        if (deleted) {
            return ResponseEntity.noContent().build();  // 204 No Content
        } else {
            return ResponseEntity.notFound().build();   // 404 Not Found
        }
    }
}
