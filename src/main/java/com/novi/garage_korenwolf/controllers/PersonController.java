package com.novi.garage_korenwolf.controllers;

import com.novi.garage_korenwolf.dto.PersonDto;
import com.novi.garage_korenwolf.models.Person;
import com.novi.garage_korenwolf.repositories.PersonRepository;
import com.novi.garage_korenwolf.services.PersonService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

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
    public ResponseEntity<Object> createPerson(@Valid @RequestBody PersonDto personDto, BindingResult br) {
        //@Valid/BindingResult br zorgen er voor dat ieder veld in personDto word gecontroleerd op een geldige invoer
        //Als 1 of meerdere br velden fouten bevatten wordt een loop afgedraaid die alle velden naloopt op foutmeldingen
        // en deze worden omgezet naar een string die wordt meegegeven aan de ResponsEntity
        //ResponseEntity is een <Object> omdat deze zowel een String of een PersonDto kan teruggeven afhankelijk van de invoer
        if (br.hasFieldErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField());
                sb.append(" : ");
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return ResponseEntity.badRequest().body(sb.toString());
        } else {
            service.createPerson(personDto);

            //pakt uri van de huidige request en plakt daar de Id van de nieuw aangemaakt person aan vast.
            //vervolgens word in de return de nieuwe person opgevraagd en meegegeven

            URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/" + personDto.id).toUriString());
            return ResponseEntity.created(uri).body(personDto);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> updatePerson(@Valid @PathVariable Long id, @RequestBody PersonDto updatedPersonDto, BindingResult br) {

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
