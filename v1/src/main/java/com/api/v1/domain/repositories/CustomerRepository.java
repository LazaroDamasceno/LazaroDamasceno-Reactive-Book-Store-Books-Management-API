package com.api.v1.domain.repositories;

import org.hibernate.validator.constraints.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.api.v1.domain.entitties.Customer;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, UUID> {
    
}
