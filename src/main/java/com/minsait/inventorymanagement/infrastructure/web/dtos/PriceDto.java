package com.minsait.inventorymanagement.infrastructure.web.dtos;

import com.minsait.inventorymanagement.domain.entities.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {
    private Long productId;
    private Long brandId;
    private Long priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;

    public static PriceDto convertToDto(Price price) {
        PriceDto dto = new PriceDto();
        dto.setProductId(price.getProductId());
        dto.setBrandId(price.getBrandId());
        dto.setPriceList(price.getPriceList());
        dto.setStartDate(price.getStartDate());
        dto.setEndDate(price.getEndDate());
        dto.setPrice(price.getPrice());
        return dto;
    }
}
