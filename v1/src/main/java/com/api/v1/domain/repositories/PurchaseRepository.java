package com.api.v1.domain.repositories;

import com.api.v1.domain.entities.Purchase;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PurchaseRepository extends ReactiveCrudRepository<Purchase, ObjectId> {

}
