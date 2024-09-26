package com.api.v1.domain.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.api.v1.domain.entities.Customer;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, ObjectId> {

}
