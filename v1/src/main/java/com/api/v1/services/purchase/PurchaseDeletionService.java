package com.api.v1.services.purchase;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PurchaseDeletionService {

    Mono<Void> deleteById(String id);
    Mono<Void> deleteAll();
    Flux<Void> deleteByCustomer(String ssn);
    Flux<Void> deleteByBook(String isbn);
    Flux<Void> deleteByYear(int year);
    Flux<Void> deleteByCustomerAndBookAndYear(String ssn, String isbn, int year);
    Flux<Void> deleteByCustomerAndBook(String ssn, String isbn);
    Flux<Void> deleteByCustomerAndYear(String ssn, int year);
    Flux<Void> deleteByBookAndYear(String isbn, int year);

}
