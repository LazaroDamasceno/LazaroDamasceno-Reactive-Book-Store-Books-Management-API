package com.api.v1.services.customer;

import com.api.v1.domain.entities.Customer;
import com.api.v1.domain.repositories.CustomerRepository;
import com.api.v1.dtos.requests.UpdateCustomerRequestDto;
import com.api.v1.dtos.responses.CustomerResponseDto;
import com.api.v1.mappers.CustomerResponseMapper;
import com.api.v1.utils.CustomerFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class CustomerUpdateServiceImpl implements CustomerUpdateService {

    @Autowired
    private CustomerFinderUtil customerFinderUtil;

    @Autowired
    private CustomerRepository repository;

    @Override
    public Mono<CustomerResponseDto> update(String ssn, UpdateCustomerRequestDto request) {
        return customerFinderUtil
                .find(ssn)
                .flatMap(existingCustomer -> {
                    existingCustomer.archive();
                    return repository.save(existingCustomer);
                })
                .flatMap(archivedCustomer -> {
                    Customer updatedCustomer = archivedCustomer.update(request);
                    return repository.save(updatedCustomer);
                })
                .flatMap(updatedCustomer -> Mono.just(CustomerResponseMapper.map(updatedCustomer)));
    }

}
