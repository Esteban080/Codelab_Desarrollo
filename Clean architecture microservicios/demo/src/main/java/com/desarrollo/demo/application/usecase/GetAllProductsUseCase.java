package com.desarrollo.demo.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;


import com.desarrollo.demo.domain.model.Product;
import com.desarrollo.demo.domain.repository.ProductRepository;

@Service
public class GetAllProductsUseCase {
    private final ProductRepository productRepository;

    public GetAllProductsUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> execute() {
        return productRepository.findAll();
    }
}