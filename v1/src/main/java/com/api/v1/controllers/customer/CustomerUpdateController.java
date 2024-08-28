package com.api.v1.controllers.customer;

import com.api.v1.dtos.requests.UpdateCustomerRequestDto;
import com.api.v1.dtos.responses.CustomerResponseDto;
import com.api.v1.services.customer.CustomerUpdateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerUpdateController {

    @Autowired
    private CustomerUpdateService service;

    @PutMapping("{ssn}/updating")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<CustomerResponseDto> update(
            @PathVariable String ssn,
            @Valid @RequestBody UpdateCustomerRequestDto request
    ) {
        return service.update(ssn,request);
    }

}
