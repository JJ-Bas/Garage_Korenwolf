package com.novi.garage_korenwolf.repositories;

import com.novi.garage_korenwolf.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CarRepository extends JpaRepository<Car, String> {
   // List<Car> findByDateAfter(LocalDate date);
}
