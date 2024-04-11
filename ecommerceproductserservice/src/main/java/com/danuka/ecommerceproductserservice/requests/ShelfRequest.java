package com.danuka.ecommerceproductserservice.requests;

import com.danuka.ecommerceproductserservice.entities.ShelfItemEntity;
import lombok.Data;

import java.util.List;

@Data
public class ShelfRequest {
    private String shopperId;
    private List<ShelfItemEntity> shelf;
}
