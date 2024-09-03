package com.api.v1.controllers.customer;

import com.api.v1.dtos.requests.CustomerRegistrationRequestDto;
import com.api.v1.dtos.responses.CustomerResponseDto;
import com.api.v1.services.customer.CustomerRegistrationService;
import com.api.v1.services.customer.CustomerUpdateService;
import com.api.v1.services.customer.CustomersDeletionService;
import com.api.v1.services.customer.CustomersRetrieveService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerRegistrationService registrationService;

    @Autowired
    private CustomersDeletionService deletionService;

    @Autowired
    private CustomersRetrieveService retrieveService;

    @Autowired
    private CustomerUpdateService updateService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CustomerResponseDto> register(@Valid @RequestBody CustomerRegistrationRequestDto request) {
        return registrationService.register(request);
    }

    @DeleteMapping
    public Mono<Void> deleteAll() {
        return deletionService.deleteAll();
    }

    @DeleteMapping("{ssn}")
    public Mono<Void> deleteBySsn(@PathVariable String ssn) {
        return deletionService.deleteBySsn(ssn);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<CustomerResponseDto> retrieveAll() {
        return retrieveService.retrieveAll();
    }

    @GetMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<CustomerResponseDto> retrieveBySsn(@PathVariable String ssn) {
        return retrieveService.retrieveBySsn(ssn);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<CustomerResponseDto> update(
            @Valid @RequestBody CustomerRegistrationRequestDto request
    ) {
        return updateService.update(request);
    }
    
}
