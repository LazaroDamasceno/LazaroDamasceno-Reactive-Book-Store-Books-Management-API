package com.api.v1.services.book;

import com.api.v1.dtos.responses.BookResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BooksRetrieveService {

    Mono<BookResponseDto> retrieveByIsbn(String isbn);

    Flux<BookResponseDto> retrieveAll();

    Flux<BookResponseDto> retrieveByAuthor(String author);

    Flux<BookResponseDto> retrieveByField(String field);

    Flux<BookResponseDto> retrieveByYear(int year);

    Flux<BookResponseDto> retrieveByAuthorAndFieldAndYear(
            String author,
            String field,
            int year
    );

    Flux<BookResponseDto> retrieveByAuthorAndField(String author, String field);

    Flux<BookResponseDto> retrieveByAuthorAndYear(String author, int year);

    Flux<BookResponseDto> retrieveByFieldAndYear(String field, int year);

}
