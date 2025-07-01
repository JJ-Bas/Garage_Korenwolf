package com.novi.garage_korenwolf.controllers;

import com.novi.garage_korenwolf.models.Person;
import com.novi.garage_korenwolf.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository repos;

    @GetMapping
    public ResponseEntity<List<Person>> getPersons() {
        return ResponseEntity.ok(repos.findAll());
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        repos.save(person);

        //pakt uri van de huidige request en plakt daar de Id van de nieuw aangemaakt person aan vast.
        //vervolgens word in de return de nieuwe person opghevraagd en meegegeven

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + person.getId()).toUriString());
        return ResponseEntity.created(uri).body(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        return repos.findById(id)
                .map(person -> {
                    person.setFirstname(updatedPerson.getFirstname());
                    person.setLastname(updatedPerson.getLastname());
                    person.setDateOfBirth(updatedPerson.getDateOfBirth());
                    person.setStreet(updatedPerson.getStreet());
                    person.setHouseNumber(updatedPerson.getHouseNumber());
                    person.setPostalCode(updatedPerson.getPostalCode());
                    person.setTelephoneNumber(updatedPerson.getTelephoneNumber());
                    person.setEmail(updatedPerson.getEmail());

                    repos.save(person);
                    return ResponseEntity.ok(person);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        if (repos.existsById(id)) {
            repos.deleteById(id);
            return ResponseEntity.noContent().build();  // 204 No Content
        } else {
            return ResponseEntity.notFound().build();   // 404 Not Found
        }
    }
}
