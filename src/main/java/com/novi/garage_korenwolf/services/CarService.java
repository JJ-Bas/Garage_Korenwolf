package com.novi.garage_korenwolf.services;

import com.novi.garage_korenwolf.controllers.PersonController;
import com.novi.garage_korenwolf.dto.CarDto;
import com.novi.garage_korenwolf.models.Car;
import com.novi.garage_korenwolf.models.Person;
import com.novi.garage_korenwolf.repositories.CarRepository;
import com.novi.garage_korenwolf.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepos;

    private final PersonRepository personRepos;

    public CarService(CarRepository carRepos, PersonRepository personRepos) {
        this.carRepos = carRepos;
        this.personRepos = personRepos;
    }

    public List<CarDto> getAllCars(){
        return carRepos.findAll()
                .stream()
                .map(car -> {
                    CarDto dto = new CarDto();
                    dto.numberplate = car.getNumberplate();
                    dto.registrationDate = car.getRegistrationDate();
                    dto.buildYear = car.getBuildYear();
                    dto.color = car.getColor();
                    dto.fuelType = car.getFuelType();
                    dto.make = car.getMake();
                    dto.model = car.getModel();
                    if (car.getPersonSet() != null) {
                        dto.personIds = car.getPersonSet()
                                .stream()
                                .mapToLong(Person::getId)
                                .toArray();
                    }

                    return dto;

                }).collect(Collectors.toList());
    }

    public CarDto createCar(CarDto carDto) {
        Car car = new Car();

        car.setNumberplate(carDto.numberplate);
        car.setRegistrationDate(carDto.registrationDate);
        car.setBuildYear(carDto.buildYear);
        car.setColor(carDto.color);
        car.setFuelType(carDto.fuelType);
        car.setMake(carDto.make);
        car.setModel(carDto.model);

        // Link persons using personIds array from DTO
        if (carDto.personIds != null && carDto.personIds.length > 0) {
            Set<Person> persons = new HashSet<>();
            for (long id : carDto.personIds) {
                personRepos.findById(id).ifPresent(persons::add);
            }
            car.setPersonSet(persons);
        }

        carRepos.save(car);

        return carDto;
    }

    public CarDto updateCar(String numberplate, CarDto updatedCarDto) {
        Optional<Car> optionalCar = carRepos.findById(numberplate);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();

            car.setRegistrationDate(updatedCarDto.registrationDate);
            car.setBuildYear(updatedCarDto.buildYear);
            car.setColor(updatedCarDto.color);
            car.setFuelType(updatedCarDto.fuelType);
            car.setMake(updatedCarDto.make);
            car.setModel(updatedCarDto.model);

            if (updatedCarDto.personIds != null) {
                Set<Person> persons = new HashSet<>();
                for (long id : updatedCarDto.personIds) {
                    personRepos.findById(id).ifPresent(persons::add);
                }
                car.setPersonSet(persons);
            }

            Car updated = carRepos.save(car);

            CarDto resultDto = new CarDto();

            resultDto.numberplate = updated.getNumberplate();
            resultDto.registrationDate = updated.getRegistrationDate();
            resultDto.buildYear = updated.getBuildYear();
            resultDto.color = updated.getColor();
            resultDto.fuelType = updated.getFuelType();
            resultDto.make = updated.getMake();
            resultDto.model = updated.getModel();

            if (updated.getPersonSet() != null) {
                resultDto.personIds = updated.getPersonSet()
                        .stream()
                        .mapToLong(Person::getId)
                        .toArray();
            }

            return resultDto;
        } else {
            return null;
            //TODO null returnen is niet netjes
        }
    }

    public boolean deleteCar(String numberplate) {
        if (carRepos.existsById(numberplate)){
            carRepos.deleteById(numberplate);
            return true;
        } else {
            return false;
        }
    }
}
