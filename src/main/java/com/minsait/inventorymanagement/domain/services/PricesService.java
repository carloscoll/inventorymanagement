package com.minsait.inventorymanagement.domain.services;

import java.time.LocalDateTime;
import java.util.Optional;

import com.minsait.inventorymanagement.domain.entities.Price;
import com.minsait.inventorymanagement.domain.ports.PricesRepository;
import com.minsait.inventorymanagement.infrastructure.web.dtos.PriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PricesService {
    private final PricesRepository pricesRepository;

    @Autowired
    public PricesService(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    public Optional<PriceDto> calculatePrice(LocalDateTime date, Long productId, Long brandId) {
        return pricesRepository.findPriceByDateAndProductIdAndBrandId(date, productId, brandId)
                .map(PriceDto::convertToDto);
    }
}