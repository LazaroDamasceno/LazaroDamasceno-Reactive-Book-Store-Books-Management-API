package com.api.v1.domain.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.api.v1.domain.entities.Customer;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, ObjectId> {

    Flux<Customer> findBy(Pageable pageable);
    
}
