package com.danuka.ecommerceproductserservice.services;

import com.danuka.ecommerceproductserservice.entities.ProductEntity;
import com.danuka.ecommerceproductserservice.entities.ProductResponse;
import com.danuka.ecommerceproductserservice.requests.ProductSearchRequest;
import com.danuka.ecommerceproductserservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getProductsByShopper(ProductSearchRequest request) {
        // Implement logic to query the database based on the provided filters
        // Example:
        List<ProductEntity> products = productRepository.findProductsByShopper(
                request.getShopperId(),
                request.getFilter().getCategory(),
                request.getFilter().getBrand()
        );

        // Convert ProductEntity to ProductResponse
        return products.stream()
                .map(productEntity -> {
                    ProductResponse response = new ProductResponse();
                    response.setProductId(productEntity.getProductId());
                    response.setCategory(productEntity.getCategory());
                    response.setBrand(productEntity.getBrand());
                    return response;
                })
                .collect(Collectors.toList());
    }
}
