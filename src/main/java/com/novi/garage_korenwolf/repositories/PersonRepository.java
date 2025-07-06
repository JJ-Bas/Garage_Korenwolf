package com.novi.garage_korenwolf.repositories;

import com.novi.garage_korenwolf.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PersonRepository extends JpaRepository<Person, Long>{
}


