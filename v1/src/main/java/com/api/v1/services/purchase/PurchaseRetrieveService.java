package com.api.v1.services.purchase;

import com.api.v1.dtos.requests.PaginationRequestDto;
import com.api.v1.dtos.responses.PurchaseResponseDto;
import reactor.core.publisher.Flux;

public interface PurchaseRetrieveService {

    Flux<PurchaseResponseDto> retrieveAll(PaginationRequestDto pagination);
    Flux<PurchaseResponseDto> retrieveByBook(String isbn, PaginationRequestDto pagination);
    Flux<PurchaseResponseDto> retrieveByCustomer(String ssn, PaginationRequestDto pagination);
    Flux<PurchaseResponseDto> retrieveByYear(int year, PaginationRequestDto pagination);
    Flux<PurchaseResponseDto> retrieveByBookAndCustomerAndYear(String isbn,
                                                               String ssn,
                                                               int year,
                                                               PaginationRequestDto pagination
    );
    Flux<PurchaseResponseDto> retrieveByBookAndCustomer(String isbn, String ssn, PaginationRequestDto pagination);
    Flux<PurchaseResponseDto> retrieveByBookAndYear(String isbn, int year, PaginationRequestDto pagination);
    Flux<PurchaseResponseDto> retrieveByCustomerAndYear(String ssn, int year, PaginationRequestDto pagination);

}
