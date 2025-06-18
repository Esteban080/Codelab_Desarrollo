package com.desarrollo.demo.application.usecase;

import org.springframework.stereotype.Service;


import com.desarrollo.demo.domain.model.Product;
import com.desarrollo.demo.domain.repository.ProductRepository;

@Service
public class FindProductByIdUseCase {
    
 
    private final ProductRepository productRepository;

    public FindProductByIdUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product execute(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}