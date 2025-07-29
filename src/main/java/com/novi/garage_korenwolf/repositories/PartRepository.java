package com.novi.garage_korenwolf.repositories;

import com.novi.garage_korenwolf.models.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
}
