package com.api.v1.domain.repositories;

import com.api.v1.domain.entities.Purchase;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface PurchaseRepository extends ReactiveCrudRepository<Purchase, UUID> {
}
