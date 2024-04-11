package com.danuka.ecommerceproductserservice.repositories;

import com.danuka.ecommerceproductserservice.entities.ShelfItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelfItemRepository extends JpaRepository<ShelfItemEntity, Long> {
}
