package com.novi.garage_korenwolf.controllers;

import com.novi.garage_korenwolf.models.Person;
import com.novi.garage_korenwolf.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
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
}
