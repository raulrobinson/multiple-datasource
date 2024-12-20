package com.rasysbox.module_c.repository;

import com.rasysbox.module_c.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
