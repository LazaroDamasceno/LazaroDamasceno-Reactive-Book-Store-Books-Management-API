package com.api.v1.services.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.builders.customer.CustomerBuilder;
import com.api.v1.domain.entities.Customer;
import com.api.v1.domain.repositories.CustomerRepository;
import com.api.v1.dtos.requests.CustomerRegistrationRequestDto;
import com.api.v1.dtos.responses.CustomerResponseDto;
import com.api.v1.exceptions.customer.DuplicatedSsnException;
import com.api.v1.mappers.customer.CustomerResponseMapper;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@Service
class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Mono<CustomerResponseDto> register(@Valid CustomerRegistrationRequestDto request) {
        return repository
            .findAll()
            .filter(customer -> customer.getSsn() != null
                    && customer.getSsn().equals(request.ssn())
                    && customer.getArchivedAt() == null
            )
            .hasElements()
            .flatMap(exists -> {
                if (exists) return Mono.error(new DuplicatedSsnException(request.ssn()));
                return Mono.defer(() -> {
                    Customer newCustomer = CustomerBuilder.create().fromDto(request).build();
                    Mono<Customer> savedCustomer = repository.save(newCustomer);
                    return savedCustomer.flatMap(customer -> Mono.just(CustomerResponseMapper.map(customer)));
                });
            });
    }
    
}
