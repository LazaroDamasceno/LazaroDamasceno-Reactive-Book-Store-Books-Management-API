package com.api.v1.services.customer;

import com.api.v1.builders.CustomerBuilder;
import com.api.v1.domain.entities.Customer;
import com.api.v1.domain.repositories.CustomerRepository;
import com.api.v1.dtos.requests.NewCustomerRequestDto;
import com.api.v1.dtos.responses.CustomerResponseDto;
import com.api.v1.mappers.CustomerResponseMapper;
import com.api.v1.utils.CustomerFinderUtil;
import jakarta.validation.Valid;
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
    public Mono<CustomerResponseDto> update(@Valid NewCustomerRequestDto request) {
        return customerFinderUtil
                .find(request.ssn())
                .flatMap(existingCustomer -> {
                    existingCustomer.archive();
                    return repository.save(existingCustomer);
                }).then(Mono.defer(() -> {
                    Customer updatedCustomer = CustomerBuilder.create().fromDto(request).build();
                    return repository
                            .save(updatedCustomer)
                            .flatMap(customer -> Mono.just(CustomerResponseMapper.map(customer)));
                }));
    }

}
