package com.minsait.inventorymanagement.infrastructure.web.controllers;

import com.minsait.inventorymanagement.domain.entities.Price;
import com.minsait.inventorymanagement.domain.services.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/prices")
public class PricesController {

    private final PricesService pricingService;

    @Autowired
    public PricesController(PricesService pricesService) {
        this.pricingService = pricesService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<Price> getPrice(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {

        Optional<Price> price = pricingService.calculatePrice(date, productId, brandId);

        return price.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}