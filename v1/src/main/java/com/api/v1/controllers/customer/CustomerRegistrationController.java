package com.api.v1.controllers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.dtos.requests.NewCustomerRequestDto;
import com.api.v1.dtos.responses.CustomerResponseDto;
import com.api.v1.services.customer.CustomerRegistrationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerRegistrationController {

    @Autowired
    private CustomerRegistrationService service;

    @PostMapping("registration")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CustomerResponseDto> register(@Valid @RequestBody NewCustomerRequestDto request) {
        return service.register(request);
    }
    
}
