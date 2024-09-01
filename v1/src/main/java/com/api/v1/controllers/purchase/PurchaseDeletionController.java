package com.api.v1.controllers.purchase;

import com.api.v1.services.purchase.PurchaseDeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/purchases")
public class PurchaseDeletionController {

    @Autowired
    private PurchaseDeletionService service;

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteById(@PathVariable String id) {
        return service.deleteById(id);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteAll() {
        return service.deleteAll();
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<Void> deleteByCustomer(@PathVariable String ssn) {
        return service.deleteByCustomer(ssn);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<Void> deleteByBook(@PathVariable String isbn) {
        return service.deleteByBook(isbn);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<Void> deleteByYear(@PathVariable int year) {
        return service.deleteByYear(year);
    }

    @DeleteMapping("{ssn}/{isbn}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<Void> deleteByCustomerAndBookAndYear(
            @PathVariable String ssn,
            @PathVariable String isbn,
            @PathVariable int year
    ) {
        return service.deleteByCustomerAndBookAndYear(ssn, isbn, year);
    }

    @DeleteMapping("{ssn}/{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<Void> deleteByCustomerAndBook(@PathVariable String ssn, @PathVariable String isbn) {
        return service.deleteByCustomerAndBook(ssn, isbn);
    }

    @DeleteMapping("{ssn}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<Void> deleteByCustomerAndYear(@PathVariable String ssn, @PathVariable int year) {
        return service.deleteByCustomerAndYear(ssn, year);
    }

    @DeleteMapping("{isbn}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<Void> deleteByBookAndYear(@PathVariable String isbn, @PathVariable int year) {
        return service.deleteByBookAndYear(isbn, year);
    }

}
