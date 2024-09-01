package com.api.v1.controllers.customer;

import com.api.v1.dtos.requests.PaginationRequestDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.api.v1.dtos.responses.CustomerResponseDto;
import com.api.v1.services.customer.CustomersRetrieveService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/customers")
public class CustomersRetrieveController {

    @Autowired
    private CustomersRetrieveService service;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<CustomerResponseDto> retrieveAll(@Valid @RequestBody PaginationRequestDto pagination) {
        return service.retrieveAll(pagination);
    }

    @GetMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<CustomerResponseDto> retrieveBySsn(@PathVariable String ssn) {
        return service.retrieveBySsn(ssn);
    }
    
}
