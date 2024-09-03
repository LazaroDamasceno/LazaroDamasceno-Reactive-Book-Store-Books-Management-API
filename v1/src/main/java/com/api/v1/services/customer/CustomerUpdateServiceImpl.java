package com.api.v1.services.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.domain.entities.Customer;
import com.api.v1.domain.repositories.CustomerRepository;
import com.api.v1.dtos.requests.CustomerRegistrationRequestDto;
import com.api.v1.dtos.responses.CustomerResponseDto;
import com.api.v1.mappers.customer.CustomerResponseMapper;
import com.api.v1.utils.customer.CustomerFinderUtil;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@Service
class CustomerUpdateServiceImpl implements CustomerUpdateService {

    @Autowired
    private CustomerFinderUtil customerFinderUtil;

    @Autowired
    private CustomerRepository repository;

    @Override
    public Mono<CustomerResponseDto> update(@Valid CustomerRegistrationRequestDto request) {
        return customerFinderUtil
                .find(request.ssn())
                .flatMap(existingCustomer -> {
                    existingCustomer.inactive();
                    return repository.save(existingCustomer);
                }).flatMap(inactiveCustomer -> {
                    Customer updatedCustomer = inactiveCustomer.update(request);
                    return repository
                            .save(updatedCustomer)
                            .flatMap(customer -> Mono.just(CustomerResponseMapper.map(customer)));
                });
    }

}
