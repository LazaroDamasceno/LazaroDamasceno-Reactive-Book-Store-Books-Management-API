package com.api.v1.controllers.book;

import com.api.v1.dtos.requests.PaginationRequestDto;
import com.api.v1.dtos.responses.BookResponseDto;
import com.api.v1.services.book.BooksRetrieveService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/books")
public class BooksRetrieveController {

    @Autowired
    private BooksRetrieveService service;

    @GetMapping("{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<BookResponseDto> retrieveByIsbn(@PathVariable String isbn) {
        return service.retrieveByIsbn(isbn);
    }

    @GetMapping("")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveAll(@Valid @RequestBody PaginationRequestDto pagination) {
        return service.retrieveAll(pagination);
    }

    @GetMapping("by-author/{author}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByAuthor(
            @NotBlank @PathVariable String author,
            @Valid @RequestBody PaginationRequestDto pagination
    ) {
        return service.retrieveByAuthor(author, pagination);
    }

    @GetMapping("by-field/{field}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByField(
            @NotBlank @PathVariable String field,
            @Valid @RequestBody PaginationRequestDto pagination
    ) {
        return service.retrieveByField(field, pagination);
    }

    @GetMapping("by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByYear(
            @PathVariable int year,
            @Valid @RequestBody PaginationRequestDto pagination
    ) {
        return service.retrieveByYear(year, pagination);
    }

    @GetMapping("by-author/{author}/by-field/{field}/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByAuthorAndFieldAndYear(
            @NotBlank @PathVariable String author,
            @NotBlank @PathVariable String field,
            @PathVariable int year,
            @Valid @RequestBody PaginationRequestDto pagination
    ) {
        return service.retrieveByAuthorAndFieldAndYear(author, field, year, pagination);
    }

    @GetMapping("by-author/{author}/by-field/{field}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByAuthorAndField(
            @NotBlank @PathVariable String author,
            @NotBlank @PathVariable String field,
            @Valid @RequestBody PaginationRequestDto pagination
    ) {
        return service.retrieveByAuthorAndField(author, field, pagination);
    }

    @GetMapping("by-author/{author}/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByAuthorAndYear(
            @NotBlank @PathVariable String author,
            @PathVariable int year,
            @Valid @RequestBody PaginationRequestDto pagination
    ) {
        return service.retrieveByAuthorAndYear(author, year, pagination);
    }

    @GetMapping("by-field/{field}/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByFieldAndYear(
            @PathVariable @NotBlank String field,
            @PathVariable int year,
            @Valid @RequestBody PaginationRequestDto pagination
    ) {
        return service.retrieveByFieldAndYear(field, year, pagination);
    }

}
