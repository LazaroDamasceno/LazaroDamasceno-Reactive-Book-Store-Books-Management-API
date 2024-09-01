package com.api.v1.controllers.purchase;

import com.api.v1.dtos.requests.PaginationRequestDto;
import com.api.v1.dtos.responses.PurchaseResponseDto;
import com.api.v1.services.purchase.PurchaseRetrieveService;
import jakarta.validation.Valid;
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
    public Flux<PurchaseResponseDto> retrieveAll(@Valid @RequestBody PaginationRequestDto pagination) {
        return service.retrieveAll(pagination);
    }

    @GetMapping("{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByBook(
            @PathVariable String isbn,
            @Valid @RequestBody PaginationRequestDto pagination
    ) {
        return service.retrieveByBook(isbn, pagination);
    }

    @GetMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByCustomer(
            @PathVariable String ssn,
            @Valid @RequestBody PaginationRequestDto pagination
    ) {
        return service.retrieveByCustomer(ssn, pagination);
    }

    @GetMapping("{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByYear(
            @PathVariable int year,
            @Valid @RequestBody PaginationRequestDto pagination
    ) {
        return service.retrieveByYear(year, pagination);
    }

    @GetMapping("{isbn}/{ssn}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByBookAndCustomerAndYear(
            @PathVariable String isbn, 
            @PathVariable String ssn, 
            @PathVariable int year,
            @Valid @RequestBody PaginationRequestDto pagination
    ) {
        return service.retrieveByBookAndCustomerAndYear(isbn, ssn, year, pagination);
    }

    @GetMapping("{isbn}/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByBookAndCustomer(
            @PathVariable String isbn,
            @PathVariable String ssn,
            @Valid @RequestBody PaginationRequestDto pagination
    ) {
        return service.retrieveByBookAndCustomer(isbn, ssn, pagination);
    }

    @GetMapping("{isbn}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByBookAndYear(
            @PathVariable String isbn,
            @PathVariable int year,
            @Valid @RequestBody PaginationRequestDto pagination
    ) {
        return service.retrieveByBookAndYear(isbn, year, pagination);
    }

    @GetMapping("{ssn}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PurchaseResponseDto> retrieveByCustomerAndYear(
            @PathVariable String ssn,
            @PathVariable int year,
            @Valid @RequestBody PaginationRequestDto pagination
    ) {
        return service.retrieveByCustomerAndYear(ssn,  year, pagination);
    }
    

}
