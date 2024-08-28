package com.api.v1.services.customer;

import com.api.v1.dtos.requests.UpdateCustomerRequestDto;
import com.api.v1.dtos.responses.CustomerResponseDto;
import reactor.core.publisher.Mono;

public interface CustomerUpdateService {

    Mono<CustomerResponseDto> update(String ssn, UpdateCustomerRequestDto request);

}
