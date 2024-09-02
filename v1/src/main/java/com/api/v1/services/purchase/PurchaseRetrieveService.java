package com.api.v1.services.purchase;

import com.api.v1.dtos.responses.PurchaseResponseDto;
import reactor.core.publisher.Flux;

public interface PurchaseRetrieveService {

    Flux<PurchaseResponseDto> retrieveAll();
    Flux<PurchaseResponseDto> retrieveByBook(String isbn);
    Flux<PurchaseResponseDto> retrieveByCustomer(String ssn);
    Flux<PurchaseResponseDto> retrieveByYear(int year);
    Flux<PurchaseResponseDto> retrieveByBookAndCustomerAndYear(String isbn, String ssn, int year);
    Flux<PurchaseResponseDto> retrieveByBookAndCustomer(String isbn, String ssn);
    Flux<PurchaseResponseDto> retrieveByBookAndYear(String isbn, int year);
    Flux<PurchaseResponseDto> retrieveByCustomerAndYear(String ssn, int year);

}
