package com.api.v1.services.book;

import com.api.v1.dtos.requests.PaginationRequestDto;
import com.api.v1.dtos.responses.BookResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BooksRetrieveService {

    Mono<BookResponseDto> retrieveByIsbn(String isbn);

    Flux<BookResponseDto> retrieveAll(PaginationRequestDto pagination);

    Flux<BookResponseDto> retrieveByAuthor(String author, PaginationRequestDto pagination);

    Flux<BookResponseDto> retrieveByField(String field, PaginationRequestDto pagination);

    Flux<BookResponseDto> retrieveByYear(int year, PaginationRequestDto pagination);

    Flux<BookResponseDto> retrieveByAuthorAndFieldAndYear(
            String author,
            String field,
            int year,
            PaginationRequestDto pagination
    );

    Flux<BookResponseDto> retrieveByAuthorAndField(String author, String field, PaginationRequestDto pagination);

    Flux<BookResponseDto> retrieveByAuthorAndYear(String author, int year, PaginationRequestDto pagination);

    Flux<BookResponseDto> retrieveByFieldAndYear(String field, int year, PaginationRequestDto pagination);

}
