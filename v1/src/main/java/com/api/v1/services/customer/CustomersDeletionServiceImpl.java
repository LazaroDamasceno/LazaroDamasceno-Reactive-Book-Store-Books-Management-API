package com.api.v1.services.customer;

import com.api.v1.domain.repositories.CustomerRepository;
import com.api.v1.exceptions.customer.CustomerDataDeletionException;
import com.api.v1.utils.customer.CustomerFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class CustomersDeletionServiceImpl implements CustomersDeletionService {

    @Autowired
    private CustomerFinderUtil customerFinderUtil;

    @Autowired
    private CustomerRepository repository;

    @Override
    public Mono<Void> deleteAll() {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (exists) return repository.deleteAll();
                    return Mono.error(CustomerDataDeletionException::new);
                });
    }

    @Override
    public Mono<Void> deleteBySsn(String ssn) {
        return customerFinderUtil
                .find(ssn)
                .flatMap(customer -> repository.delete(customer));
    }

}
