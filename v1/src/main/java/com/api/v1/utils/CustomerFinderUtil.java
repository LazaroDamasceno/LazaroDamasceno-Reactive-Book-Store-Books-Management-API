package com.api.v1.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.v1.domain.entities.Customer;
import com.api.v1.domain.repositories.CustomerRepository;
import com.api.v1.exceptions.customer.CustomerNotFoundError;

import reactor.core.publisher.Mono;

@Component
public class CustomerFinderUtil {

    @Autowired
    private CustomerRepository repository;

    public Mono<Customer> find(String ssn) {
        return repository
            .findAll()
            .filter(e -> e.getSsn().equals(ssn)
                && e.getArchivedAt() == null
            )
            .singleOrEmpty()
            .switchIfEmpty(Mono.error(new CustomerNotFoundError(ssn)));
    }
    
}

