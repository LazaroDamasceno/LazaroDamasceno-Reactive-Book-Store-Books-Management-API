package com.api.v1.services.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.builders.CustomerBuilder;
import com.api.v1.domain.entities.Customer;
import com.api.v1.domain.repositories.CustomerRepository;
import com.api.v1.dtos.requests.NewCustomerRequestDto;
import com.api.v1.dtos.responses.CustomerResponseDto;
import com.api.v1.exceptions.DuplicatedSsnError;
import com.api.v1.mappers.CustomerResponseMapper;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@Service
class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Mono<CustomerResponseDto> register(@Valid NewCustomerRequestDto request) {
        return repository
            .findAll()
            .filter(customer -> customer.getSsn().equals(request.ssn())
                && customer.getArchivedAt() == null
            )
            .hasElements()
            .flatMap(exists -> {
                if (exists) return Mono.error(new DuplicatedSsnError(request.ssn()));
                return Mono.defer(() -> {
                    Customer newCustomer = CustomerBuilder.create().fromDto(request).build();
                    Mono<Customer> savedCustomer = repository.save(newCustomer);
                    return savedCustomer.flatMap(customer -> Mono.just(CustomerResponseMapper.map(customer)));
                });
            });
    }
    
}
