package com.novi.garage_korenwolf.controllers;

import com.novi.garage_korenwolf.models.Car;
import com.novi.garage_korenwolf.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        return ResponseEntity.ok(repos.findAll());
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        repos.save(car);

        //pakt uri van de huidige request en plakt daar de Id van de nieuw aangemaakt person aan vast.
        //vervolgens word in de return de nieuwe person opghevraagd en meegegeven

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + car.getNumberplate()).toUriString());
        return ResponseEntity.created(uri).body(car);
    }

    @PutMapping("/{numberplate}")
    public ResponseEntity<Car> updateCar(@PathVariable String numberplate, @RequestBody Car updatedCar) {
        return repos.findById(numberplate)
                .map(car -> {
                    car.setOwnerName(updatedCar.getOwnerName());
                    car.setRegistrationDate(updatedCar.getRegistrationDate());
                    car.setBuildYear(updatedCar.getBuildYear());
                    car.setColor(updatedCar.getColor());
                    car.setFuelType(updatedCar.getFuelType());
                    car.setMake(updatedCar.getMake());
                    car.setModel(updatedCar.getModel());

                    repos.save(car);
                    return ResponseEntity.ok(car);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{numberplate}")
    public ResponseEntity<Void> deletePerson(@PathVariable String numberplate) {
        if (repos.existsById(numberplate)) {
            repos.deleteById(numberplate);
            return ResponseEntity.noContent().build();  // 204 No Content
        } else {
            return ResponseEntity.notFound().build();   // 404 Not Found
        }
    }


}
