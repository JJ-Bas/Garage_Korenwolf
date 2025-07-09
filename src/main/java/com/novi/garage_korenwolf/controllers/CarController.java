package com.novi.garage_korenwolf.controllers;

import com.novi.garage_korenwolf.dto.CarDto;
import com.novi.garage_korenwolf.dto.PersonDto;
import com.novi.garage_korenwolf.models.Car;
import com.novi.garage_korenwolf.repositories.CarRepository;
import com.novi.garage_korenwolf.services.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
    public ResponseEntity<List<CarDto>> getCars() {
        List<CarDto> cars = service.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @PostMapping
    public ResponseEntity<Object> createCar(@Valid @RequestBody CarDto carDto, BindingResult br) {
        if (br.hasFieldErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField());
                sb.append(" : ");
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return ResponseEntity.badRequest().body(sb.toString());
        }
        else {
            service.createCar(carDto);
                        URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/" + carDto.numberplate).toUriString());
            return ResponseEntity.created(uri).body(carDto);
        }
    }

    @PutMapping("/{numberplate}")
    public ResponseEntity<Object> updateCar(@PathVariable String numberplate,@Valid @RequestBody CarDto updatedCarDto, BindingResult br) {

        if (br.hasFieldErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField());
                sb.append(" : ");
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return ResponseEntity.badRequest().body(sb.toString());
        }
        CarDto updatedDto = service.updateCar(numberplate, updatedCarDto);
        if (updatedDto != null) {
            return ResponseEntity.ok(updatedDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{numberplate}")
    public ResponseEntity<Void> deleteCar(@PathVariable String numberplate) {
        boolean deleted = service.deleteCar(numberplate);
        if (deleted) {
            return ResponseEntity.noContent().build();  // 204 No Content
        } else {
            return ResponseEntity.notFound().build();   // 404 Not Found
        }
    }




}
