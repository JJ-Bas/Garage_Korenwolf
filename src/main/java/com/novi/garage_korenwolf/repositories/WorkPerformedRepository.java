package com.novi.garage_korenwolf.repositories;

import com.novi.garage_korenwolf.models.WorkPerformed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkPerformedRepository extends JpaRepository<WorkPerformed, Long> {
}
