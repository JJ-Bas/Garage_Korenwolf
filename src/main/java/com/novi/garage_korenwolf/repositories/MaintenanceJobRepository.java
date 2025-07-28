package com.novi.garage_korenwolf.repositories;

import com.novi.garage_korenwolf.models.MaintenanceJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceJobRepository extends JpaRepository<MaintenanceJob,Long> {
}
