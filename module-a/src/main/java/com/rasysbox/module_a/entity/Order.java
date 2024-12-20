package com.rasysbox.module_a.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Long id;

    @Column(name = "order_number")
    private String orderNumber;
}
