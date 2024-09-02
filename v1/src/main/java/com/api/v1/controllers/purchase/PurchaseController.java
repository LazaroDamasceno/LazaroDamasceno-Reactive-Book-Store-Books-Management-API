package com.api.v1.controllers.purchase;

import com.api.v1.domain.entities.Purchase;
import com.api.v1.dtos.responses.PurchaseResponseDto;
import com.api.v1.services.purchase.PurchaseDeletionService;
import com.api.v1.services.purchase.PurchaseRegistrationService;
import com.api.v1.services.purchase.PurchaseRetrieveService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.api.v1.annotations.ISBN;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseDeletionService deletionService;

    @Autowired
    private PurchaseRegistrationService registrationService;

    @Autowired
    private PurchaseRetrieveService retrieveService;

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteAll() {
        return deletionService.deleteAll();
    }

    @DeleteMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteByCustomer(@PathVariable String ssn) {
        return deletionService.deleteByCustomer(ssn);
    }

    @DeleteMapping("{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteByBook(@PathVariable @ISBN String isbn) {
        return deletionService.deleteByBook(isbn);
    }

    @DeleteMapping("{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteByYear(@PathVariable int year) {
        return deletionService.deleteByYear(year);
    }

    @DeleteMapping("{ssn}/{isbn}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteByCustomerAndBookAndYear(
            @PathVariable String ssn,
            @PathVariable @ISBN String isbn,
            @PathVariable int year
    ) {
        return deletionService.deleteByCustomerAndBookAndYear(ssn, isbn, year);
    }

    @DeleteMapping("{ssn}/{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteByCustomerAndBook(@PathVariable String ssn, @PathVariable @ISBN String isbn) {
        return deletionService.deleteByCustomerAndBook(ssn, isbn);
    }

    @DeleteMapping("{ssn}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteByCustomerAndYear(@PathVariable String ssn, @PathVariable int year) {
        return deletionService.deleteByCustomerAndYear(ssn, year);
    }

    @DeleteMapping("{isbn}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteByBookAndYear(@PathVariable @ISBN String isbn, @PathVariable int year) {
        return deletionService.deleteByBookAndYear(isbn, year);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<PurchaseResponseDto> register(@Valid @RequestBody Purchase purchase) {
        return registrationService.register(purchase);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveAll() {
        return retrieveService.retrieveAll();
    }

    @GetMapping("{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByBook(@PathVariable @ISBN String isbn) {
        return retrieveService.retrieveByBook(isbn);
    }

    @GetMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByCustomer(@PathVariable String ssn) {
        return retrieveService.retrieveByCustomer(ssn);
    }

    @GetMapping("{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByYear(@PathVariable int year) {
        return retrieveService.retrieveByYear(year);
    }

    @GetMapping("{isbn}/{ssn}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByBookAndCustomerAndYear(
            @PathVariable @ISBN String isbn,
            @PathVariable String ssn,
            @PathVariable int year
    ) {
        return retrieveService.retrieveByBookAndCustomerAndYear(isbn, ssn, year);
    }

    @GetMapping("{isbn}/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByBookAndCustomer(
            @PathVariable @ISBN String isbn,
            @PathVariable String ssn
    ) {
        return retrieveService.retrieveByBookAndCustomer(isbn, ssn);
    }

    @GetMapping("{isbn}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByBookAndYear(
            @PathVariable @ISBN String isbn,
            @PathVariable int year
    ) {
        return retrieveService.retrieveByBookAndYear(isbn, year);
    }

    @GetMapping("{ssn}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByCustomerAndYear(
            @PathVariable String ssn,
            @PathVariable int year
    ) {
        return retrieveService.retrieveByCustomerAndYear(ssn,  year);
    }

}
