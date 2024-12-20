package com.rasysbox.central.service;

import com.rasysbox.module_c.entity.Product;
import com.rasysbox.module_c.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error finding products");
        }
    }
}
