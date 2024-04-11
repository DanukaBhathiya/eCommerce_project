package com.danuka.ecommerceproductserservice.services;
import com.danuka.ecommerceproductserservice.entities.ShelfItemEntity;
import com.danuka.ecommerceproductserservice.requests.ShelfRequest;
import com.danuka.ecommerceproductserservice.repositories.ShelfItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ShelfService {

    private final ShelfItemRepository shelfItemRepository;

    public ShelfService(ShelfItemRepository shelfItemRepository) {

        this.shelfItemRepository = shelfItemRepository;

    }

    public void saveShelfItems(ShelfRequest request) {

        // Convert ShelfRequest to entity and save to database

        // You can use ModelMapper or manual conversion

        // Example:

        for (ShelfItemEntity shelfItemEntity : request.getShelf()) {

            ShelfItemEntity entity = new ShelfItemEntity();

            entity.setShopperId(request.getShopperId());

            entity.setProductId(shelfItemEntity.getProductId());

            entity.setRelevancyScore(shelfItemEntity.getRelevancyScore());

            shelfItemRepository.save(entity);

        }

    }

}

