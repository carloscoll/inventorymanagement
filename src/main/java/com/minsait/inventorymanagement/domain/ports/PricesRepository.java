package com.minsait.inventorymanagement.domain.ports;

import com.minsait.inventorymanagement.domain.entities.Price;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PricesRepository {
    Optional<Price> findPriceByDateAndProductIdAndBrandId(@Param("date") LocalDateTime date,
                                                          @Param("productId") Long productId,
                                                          @Param("brandId") Long brandId);
}