package com.novi.garage_korenwolf.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    /*
    @Autowired
    private CarController repos;

    @GetMapping("/after")
    public ResponseEntity<List<Car>> getCarsAfter(@RequestParam LocalDate date) {
        return ResponseEntity.ok(repos.findByDateAfter(date));
    }

     */

}
