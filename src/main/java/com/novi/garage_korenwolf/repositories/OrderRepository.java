package com.novi.garage_korenwolf.repositories;

import com.novi.garage_korenwolf.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
