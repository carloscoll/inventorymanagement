package com.minsait.inventorymanagement.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesJPARepository extends JpaRepository<PriceEntity, Long> {

}
