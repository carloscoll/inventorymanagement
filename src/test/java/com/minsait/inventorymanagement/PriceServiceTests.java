package com.minsait.inventorymanagement;

import static org.junit.jupiter.api.Assertions.*;

import com.minsait.inventorymanagement.infrastructure.web.dtos.PriceDto;
import com.minsait.inventorymanagement.domain.services.PricesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@SpringBootTest
public class PriceServiceTests {

    @Autowired
    private PricesService priceService;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    public void test1() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14 10:00:00", formatter);
        Long productId = 35455L;
        Long brandId = 1L;
        Optional<PriceDto> result = priceService.calculatePrice(date, productId, brandId);
        assertTrue(result.isPresent(), "Result doesn't be empty");
        PriceDto resultDto = result.get();
        assertEquals(resultDto.getPrice(), new BigDecimal("35.5"));
    }

    @Test
    public void test2() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14 16:00:00", formatter);
        Long productId = 35455L;
        Long brandId = 1L;
        Optional<PriceDto> result = priceService.calculatePrice(date, productId, brandId);
        assertTrue(result.isPresent(), "Result doesn't be empty");
        PriceDto resultDto = result.get();
        assertEquals(resultDto.getPrice(), new BigDecimal("25.45"));
    }

    @Test
    public void test3() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14 21:00:00", formatter);
        Long productId = 35455L;
        Long brandId = 1L;
        Optional<PriceDto> result = priceService.calculatePrice(date, productId, brandId);
        assertTrue(result.isPresent(), "Result doesn't be empty");
        PriceDto resultDto = result.get();
        assertEquals(resultDto.getPrice(), new BigDecimal("35.5"));
    }

    @Test
    public void test4() {
        LocalDateTime date = LocalDateTime.parse("2020-06-15 10:00:00", formatter);
        Long productId = 35455L;
        Long brandId = 1L;
        Optional<PriceDto> result = priceService.calculatePrice(date, productId, brandId);
        assertTrue(result.isPresent(), "Result doesn't be empty");
        PriceDto resultDto = result.get();
        assertEquals(resultDto.getPrice(), new BigDecimal("30.5"));
    }

    @Test
    public void test5() {
        LocalDateTime date = LocalDateTime.parse("2020-06-16 21:00:00", formatter);
        Long productId = 35455L;
        Long brandId = 1L;
        Optional<PriceDto> result = priceService.calculatePrice(date, productId, brandId);
        assertTrue(result.isPresent(), "Result doesn't be empty");
        PriceDto resultDto = result.get();
        assertEquals(resultDto.getPrice(), new BigDecimal("38.95"));
    }
}
