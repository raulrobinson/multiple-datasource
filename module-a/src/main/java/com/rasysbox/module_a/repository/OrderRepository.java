package com.rasysbox.module_a.repository;

import com.rasysbox.module_a.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
