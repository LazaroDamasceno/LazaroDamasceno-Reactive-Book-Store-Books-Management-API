package com.api.v1.controllers.book;

import com.api.v1.dtos.responses.BookResponseDto;
import com.api.v1.services.book.BooksRetrieveService;
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
    public Flux<BookResponseDto> retrieveAll() {
        return service.retrieveAll();
    }

    @GetMapping("by-author/{author}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByAuthor(@NotBlank @PathVariable String author) {
        return service.retrieveByAuthor(author);
    }

    @GetMapping("by-field/{field}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByField(@NotBlank @PathVariable String field) {
        return service.retrieveByField(field);
    }

    @GetMapping("by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByYear(int year) {
        return service.retrieveByYear(year);
    }

    @GetMapping("by-author/{author}/by-field/{field}/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByAuthorAndFieldAndYear(
            @NotBlank @PathVariable String author,
            @NotBlank @PathVariable String field,
            @PathVariable int year
    ) {
        return service.retrieveByAuthorAndFieldAndYear(author, field, year);
    }

    @GetMapping("by-author/{author}/by-field/{field}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByAuthorAndField(
            @NotBlank @PathVariable String author,
            @NotBlank @PathVariable String field
    ) {
        return service.retrieveByAuthorAndField(author, field);
    }

    @GetMapping("by-author/{author}/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByAuthorAndYear(
            @NotBlank @PathVariable String author,
            @PathVariable int year
    ) {
        return service.retrieveByAuthorAndYear(author, year);
    }

    @GetMapping("by-field/{field}/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByFieldAndYear(
            @PathVariable @NotBlank String field,
            @PathVariable int year
    ) {
        return service.retrieveByFieldAndYear(field, year);
    }

}
