package com.novi.garage_korenwolf.services;

import com.novi.garage_korenwolf.dto.CarDto;
import com.novi.garage_korenwolf.dto.PersonDto;
import com.novi.garage_korenwolf.models.Car;
import com.novi.garage_korenwolf.models.Person;
import com.novi.garage_korenwolf.repositories.CarRepository;
import com.novi.garage_korenwolf.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository repos;

    public CarService(CarRepository repos) {
        this.repos = repos;
    }

    public List<CarDto> getAllCars(){
        return repos.findAll()
                .stream()
                .map(car -> {
                    CarDto dto = new CarDto();
                    dto.numberplate = car.getNumberplate();
                    dto.ownerId = car.getOwnerId();
                    dto.registrationDate = car.getRegistrationDate();
                    dto.buildYear = car.getBuildYear();
                    dto.color = car.getColor();
                    dto.fuelType = car.getFuelType();
                    dto.make = car.getMake();
                    dto.model = car.getModel();
                    return dto;

                }).collect(Collectors.toList());
    }

    public CarDto createCar(CarDto carDto) {
        Car car = new Car();
        car.setOwnerId(carDto.ownerId);
        car.setRegistrationDate(carDto.registrationDate);
        car.setBuildYear(carDto.buildYear);
        car.setColor(carDto.color);
        car.setFuelType(carDto.fuelType);
        car.setMake(carDto.make);
        car.setModel(carDto.model);
        repos.save(car);
        carDto.numberplate = car.getNumberplate();
        return carDto;
    }

    public CarDto updateCar(String numberplate, CarDto updatedCarDto) {
        Optional<Car> optionalCar = repos.findById(numberplate);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();

            car.setOwnerId(updatedCarDto.ownerId);
            car.setRegistrationDate(updatedCarDto.registrationDate);
            car.setBuildYear(updatedCarDto.buildYear);
            car.setColor(updatedCarDto.color);
            car.setFuelType(updatedCarDto.fuelType);
            car.setMake(updatedCarDto.make);
            car.setModel(updatedCarDto.model);

            Car updated = repos.save(car);

            CarDto resultDto = new CarDto();

            resultDto.numberplate = updated.getNumberplate();
            resultDto.ownerId = updated.getOwnerId();
            resultDto.registrationDate = updated.getRegistrationDate();
            resultDto.buildYear = updated.getBuildYear();
            resultDto.color = updated.getColor();
            resultDto.fuelType = updated.getFuelType();
            resultDto.make = updated.getMake();
            resultDto.model = updated.getModel();

            return resultDto;
        } else {
            return null;
            //TODO null returnen is niet netjes
        }
    }

    public boolean deleteCar(String numberplate) {
        if (repos.existsById(numberplate)){
            repos.deleteById(numberplate);
            return true;
        } else {
            return false;
        }
    }
}
