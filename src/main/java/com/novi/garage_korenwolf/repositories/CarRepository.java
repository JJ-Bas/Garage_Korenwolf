package com.novi.garage_korenwolf.repositories;

import com.novi.garage_korenwolf.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
   // List<Car> findByDateAfter(LocalDate date);
}
