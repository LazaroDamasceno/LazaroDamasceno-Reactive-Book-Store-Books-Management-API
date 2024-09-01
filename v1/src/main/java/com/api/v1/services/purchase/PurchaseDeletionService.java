package com.api.v1.services.purchase;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Mono;

public interface PurchaseDeletionService {

    Mono<Void> deleteById(String id);
    Mono<Void> deleteAll();
    Mono<Void> deleteByCustomer(String ssn);
    Mono<Void> deleteByBook(String isbn);
    Mono<Void> deleteByYear(int year);
    Mono<Void> deleteByCustomerAndBookAndYear(String ssn, String isbn, int year);
    Mono<Void> deleteByCustomerAndBook(String ssn, String isbn);
    Mono<Void> deleteByCustomerAndYear(String ssn, int year);
    Mono<Void> deleteByBookAndYear(String isbn, int year);

}
