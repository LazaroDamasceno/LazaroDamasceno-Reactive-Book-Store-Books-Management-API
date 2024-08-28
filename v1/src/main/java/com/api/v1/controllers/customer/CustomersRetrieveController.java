package com.api.v1.controllers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.dtos.responses.CustomerResponseDto;
import com.api.v1.services.customer.CustomersRetrieveService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/customers")
public class CustomersRetrieveController {

    @Autowired
    private CustomersRetrieveService service;

    @GetMapping("retrieving")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<CustomerResponseDto> retrieveAll() {
        return service.retrieveAll();
    }

    @GetMapping("{ssn}/retrieving")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<CustomerResponseDto> retrieveBySsn(@PathVariable String ssn) {
        return service.retrieveBySsn(ssn);
    }
    
}
