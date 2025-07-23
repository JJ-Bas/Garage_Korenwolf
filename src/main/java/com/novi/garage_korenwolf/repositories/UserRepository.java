package com.novi.garage_korenwolf.repositories;

import com.novi.garage_korenwolf.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
