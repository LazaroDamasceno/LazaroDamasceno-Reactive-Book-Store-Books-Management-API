package com.api.v1.controllers.book;

import com.api.v1.dtos.requests.BookRegistrationRequestDto;
import com.api.v1.dtos.responses.BookResponseDto;
import com.api.v1.services.book.BookRegistrationService;
import com.api.v1.services.book.BookUpdateService;
import com.api.v1.services.book.BooksDeletionService;
import com.api.v1.services.book.BooksRetrieveService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.api.v1.annotations.ISBN;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    @Autowired
    private BookRegistrationService registrationService;

    @Autowired
    private BooksDeletionService deletionService;

    @Autowired
    private BooksRetrieveService retrieveService;

    @Autowired
    private BookUpdateService updateService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<BookResponseDto> register(@Valid @RequestBody BookRegistrationRequestDto request) {
        return registrationService.register(request);
    }

    @DeleteMapping()
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAll() {
        return deletionService.deleteAll();
    }

    @DeleteMapping("{isbn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteByIsbn(@PathVariable @ISBN String isbn) {
        return deletionService.deleteByIsbn(isbn);
    }

    @GetMapping("{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<BookResponseDto> retrieveByIsbn(@PathVariable @ISBN String isbn) {
        return retrieveService.retrieveByIsbn(isbn);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveAll() {
        return retrieveService.retrieveAll();
    }

    @GetMapping("{author}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByAuthor(@NotBlank @PathVariable String author) {
        return retrieveService.retrieveByAuthor(author);
    }

    @GetMapping("{field}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByField(@NotBlank @PathVariable String field) {
        return retrieveService.retrieveByField(field);
    }

    @GetMapping("{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByYear(@PathVariable int year) {
        return retrieveService.retrieveByYear(year);
    }

    @GetMapping("{author}/{field}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByAuthorAndFieldAndYear(
            @NotBlank @PathVariable String author,
            @NotBlank @PathVariable String field,
            @PathVariable int year
    ) {
        return retrieveService.retrieveByAuthorAndFieldAndYear(author, field, year);
    }

    @GetMapping("{author}/{field}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByAuthorAndField(
            @NotBlank @PathVariable String author,
            @NotBlank @PathVariable String field
    ) {
        return retrieveService.retrieveByAuthorAndField(author, field);
    }

    @GetMapping("{author}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByAuthorAndYear(
            @NotBlank @PathVariable String author,
            @PathVariable int year
    ) {
        return retrieveService.retrieveByAuthorAndYear(author, year);
    }

    @GetMapping("{field}/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> retrieveByFieldAndYear(
            @PathVariable @NotBlank String field,
            @PathVariable int year
    ) {
        return retrieveService.retrieveByFieldAndYear(field, year);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<BookResponseDto> update(@Valid @RequestBody BookRegistrationRequestDto request) {
        return updateService.update(request);
    }

    @DeleteMapping("{author}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteByAuthor(String author) {
        return deletionService.deleteByAuthor(author);
    }

    @DeleteMapping("{field}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteByField(String field) {
        return deletionService.deleteByField(field);
    }

    @DeleteMapping("{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteByYear(int year) {
        return deletionService.deleteByYear(year);
    }

    @DeleteMapping("{version}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteByVersion(int version) {
        return deletionService.deleteByVersion(version);
    }

    @DeleteMapping("{publisher}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteByPublisher(String publisher) {
        return deletionService.deleteByPublisher(publisher);
    }

}
