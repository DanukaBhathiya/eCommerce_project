package com.danuka.ecommerceproductserservice.requests;

import com.danuka.ecommerceproductserservice.entities.ProductFilter;
import lombok.Data;

@Data
public class ProductSearchRequest {
    private String shopperId;
    private ProductFilter filter;
    private int limit;
}
