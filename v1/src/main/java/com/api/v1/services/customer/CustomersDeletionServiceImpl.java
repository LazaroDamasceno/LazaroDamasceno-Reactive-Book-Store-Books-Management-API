package com.api.v1.services.customer;

import com.api.v1.domain.repositories.CustomerRepository;
import com.api.v1.utils.CustomerFinderUtil;
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
        return repository.deleteAll();
    }

    @Override
    public Mono<Void> deleteBySsn(String ssn) {
        return customerFinderUtil
                .find(ssn)
                .flatMap(customer -> repository.delete(customer));
    }

}
