package com.minsait.inventorymanagement.infrastructure.adapters;

import com.minsait.inventorymanagement.domain.entities.Price;
import com.minsait.inventorymanagement.domain.ports.PricesRepository;
import com.minsait.inventorymanagement.infrastructure.persistence.PriceEntity;
import com.minsait.inventorymanagement.infrastructure.persistence.PricesJPARepository;
import com.minsait.inventorymanagement.shared.util.DateConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class PricesRepositoryAdapter implements PricesRepository {

    private final PricesJPARepository jpaRepository;

    public PricesRepositoryAdapter(PricesJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Price> findPriceByDateAndProductIdAndBrandId(LocalDateTime date, Long productId, Long brandId) {
        Optional<PriceEntity> p = jpaRepository.findAll()
                .stream()
                .filter(priceEntity -> priceEntity.getProductId().equals(productId) &&
                        priceEntity.getBrandId().equals(brandId) &&
                        !date.isBefore(DateConverter.convertStringToLocalDateTime(priceEntity.getStartDate())) &&
                        !date.isAfter(DateConverter.convertStringToLocalDateTime(priceEntity.getEndDate())))
                .findFirst();
        return p.map(this::convertToDomainEntity);
    }

    private Price convertToDomainEntity(PriceEntity priceEntity) {
        Price price = new Price();

        price.setBrandId(priceEntity.getBrandId());
        price.setStartDate(DateConverter.convertStringToLocalDateTime(priceEntity.getStartDate()));
        price.setEndDate(DateConverter.convertStringToLocalDateTime(priceEntity.getEndDate()));
        price.setPriceList(priceEntity.getPriceList());
        price.setProductId(priceEntity.getProductId());
        price.setPriority(priceEntity.getPriority());
        price.setPrice(priceEntity.getPrice());
        price.setCurrency(priceEntity.getCurrency());

        return price;
    }
}