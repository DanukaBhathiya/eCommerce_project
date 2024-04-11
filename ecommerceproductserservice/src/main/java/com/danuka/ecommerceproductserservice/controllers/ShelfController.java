package com.danuka.ecommerceproductserservice.controllers;

import com.danuka.ecommerceproductserservice.requests.ShelfRequest;
import com.danuka.ecommerceproductserservice.services.ShelfService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shelf")
public class ShelfController {

    private final ShelfService shelfService;

    public ShelfController(ShelfService shelfService) {
        this.shelfService = shelfService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveShelfItems(@RequestBody ShelfRequest shelfRequest) {
        shelfService.saveShelfItems(shelfRequest);
        return ResponseEntity.ok("Shelf items saved successfully");
    }
}
