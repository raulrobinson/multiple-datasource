package com.rasysbox.central.service;

import com.rasysbox.module_a.entity.Order;
import com.rasysbox.module_a.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        try {
            return orderRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error getting data");
        }
    }
}
