package com.danuka.ecommerceproductserservice.repositories;

import com.danuka.ecommerceproductserservice.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT p FROM ProductEntity p WHERE p.shopperId = :shopperId " +
            "AND (:category IS NULL OR p.category = :category) " +
            "AND (:brand IS NULL OR p.brand = :brand)")
    List<ProductEntity> findProductsByShopper(
            @Param("shopperId") String shopperId,
            @Param("category") String category,
            @Param("brand") String brand
    );
}
