package com.danuka.ecommerceproductserservice.controllers;

import com.danuka.ecommerceproductserservice.entities.ProductFilter;
import com.danuka.ecommerceproductserservice.entities.ProductResponse;
import com.danuka.ecommerceproductserservice.requests.ProductSearchRequest;
import com.danuka.ecommerceproductserservice.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/byShopper")
    public ResponseEntity<List<ProductResponse>> getProductsByShopper(
            @RequestParam String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(defaultValue = "10") int limit
    ) {
        ProductSearchRequest request = new ProductSearchRequest();
        request.setShopperId(shopperId);
        ProductFilter filter = new ProductFilter();
        filter.setCategory(category);
        filter.setBrand(brand);
        request.setFilter(filter);
        request.setLimit(limit);

        List<ProductResponse> products = productService.getProductsByShopper(request);
        return ResponseEntity.ok(products);
    }
}
