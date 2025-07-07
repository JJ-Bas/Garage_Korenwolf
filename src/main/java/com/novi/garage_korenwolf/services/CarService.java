package com.novi.garage_korenwolf.services;

import com.novi.garage_korenwolf.repositories.CarRepository;
import com.novi.garage_korenwolf.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository repos;

    public CarService(CarRepository repos) {
        this.repos = repos;
    }
}
