package com.api.v1.services.customer;

import com.api.v1.dtos.requests.PaginationRequestDto;
import com.api.v1.dtos.responses.CustomerResponseDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomersRetrieveService {
    
    Flux<CustomerResponseDto> retrieveAll(PaginationRequestDto pagination);

    Mono<CustomerResponseDto> retrieveBySsn(String ssn);

}
