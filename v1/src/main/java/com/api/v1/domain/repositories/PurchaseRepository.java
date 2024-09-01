package com.api.v1.domain.repositories;

import com.api.v1.domain.entities.Purchase;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface PurchaseRepository extends ReactiveCrudRepository<Purchase, UUID> {

    Flux<Purchase> findBy(Pageable pageable);

}
