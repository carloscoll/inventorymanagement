package com.minsait.inventorymanagement.infrastructure.web.controllers;

import com.minsait.inventorymanagement.domain.services.PricesService;
import com.minsait.inventorymanagement.infrastructure.web.dtos.PriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getPVP")
    public ResponseEntity<PriceDto> getPrice(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {

        Optional<PriceDto> price = pricingService.calculatePrice(date, productId, brandId);

        return price.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handlePriceCalculationException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}