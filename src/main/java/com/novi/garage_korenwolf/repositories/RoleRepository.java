package com.novi.garage_korenwolf.repositories;

import com.novi.garage_korenwolf.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(String user);
}
