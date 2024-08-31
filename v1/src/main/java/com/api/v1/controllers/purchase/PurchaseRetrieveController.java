package com.api.v1.controllers.purchase;

import com.api.v1.dtos.responses.PurchaseResponseDto;
import com.api.v1.services.purchase.PurchaseRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v1/purchases")
public class PurchaseRetrieveController {

    @Autowired
    private PurchaseRetrieveService service;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveAll() {
        return service.retrieveAll();
    }

    @GetMapping("{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByBook(@PathVariable String isbn) {
        return service.retrieveByBook(isbn);
    }

    @GetMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByCustomer(@PathVariable String ssn) {
        return service.retrieveByCustomer(ssn);
    }

    @GetMapping("{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByYear(@PathVariable int year) {
        return service.retrieveByYear(year);
    }

    @GetMapping("{isbn}/{ssn}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByBookAndCustomerAndYear(
            @PathVariable String isbn, 
            @PathVariable String ssn, 
            @PathVariable int year
    ) {
        return service.retrieveByBookAndCustomerAndYear(isbn, ssn, year);
    }

    @GetMapping("{isbn}/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByBookAndCustomer(
            @PathVariable String isbn,
            @PathVariable String ssn
    ) {
        return service.retrieveByBookAndCustomer(isbn, ssn);
    }

    @GetMapping("{isbn}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByBookAndYear(
            @PathVariable String isbn,
            @PathVariable int year
    ) {
        return service.retrieveByBookAndYear(isbn,  year);
    }

    @GetMapping("{isbn}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByCustomerAndYear(
            @PathVariable String ssn,
            @PathVariable int year
    ) {
        return service.retrieveByCustomerAndYear(ssn,  year);
    }
    

}
