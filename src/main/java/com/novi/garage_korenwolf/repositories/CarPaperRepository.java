package com.novi.garage_korenwolf.repositories;

import com.novi.garage_korenwolf.models.CarPaper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarPaperRepository extends JpaRepository<CarPaper,Long> {
    List<CarPaper> findByPersonId(Long personId);
}
