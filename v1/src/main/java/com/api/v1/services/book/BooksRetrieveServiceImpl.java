package com.api.v1.services.book;

import com.api.v1.domain.repositories.BookRepository;
import com.api.v1.dtos.responses.BookResponseDto;
import com.api.v1.mappers.book.BookResponseMapper;
import com.api.v1.utils.book.BookFinderUtil;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class BooksRetrieveServiceImpl implements BooksRetrieveService {
    
    @Autowired
    private BookFinderUtil bookFinderUtil;
    
    @Autowired
    private BookRepository repository;
    
    @Override
    public Mono<BookResponseDto> retrieveByIsbn(String isbn) {
        return bookFinderUtil
                .find(isbn)
                .flatMap(book -> Mono.just(BookResponseMapper.map(book)));
    }

    @Override
    public Flux<BookResponseDto> retrieveAll() {
        return repository
                .findAll()
                .flatMap(book -> Flux.just(BookResponseMapper.map(book)));
    }

    @Override
    public Flux<BookResponseDto> retrieveByAuthor(@NotBlank String author) {
        return repository
                .findAll()
                .filter(e -> e.getAuthor().equals(author))
                .flatMap(book -> Flux.just(BookResponseMapper.map(book)));
    }

    @Override
    public Flux<BookResponseDto> retrieveByField(@NotBlank String field) {
        return repository
                .findAll()
                .filter(e -> e.getField().equals(field))
                .flatMap(book -> Flux.just(BookResponseMapper.map(book)));
    }

    @Override
    public Flux<BookResponseDto> retrieveByYear(int year) {
        return repository
                .findAll()
                .filter(e -> e.getPublishingYear() == year)
                .flatMap(book -> Flux.just(BookResponseMapper.map(book)));
    }

    @Override
    public Flux<BookResponseDto> retrieveByAuthorAndFieldAndYear(
            @NotBlank String author,
            @NotBlank String field,
            int year
    ) {
        return repository
                .findAll()
                .filter(e -> e.getAuthor().equals(author)
                        && e.getField().equals(field)
                        && e.getPublishingYear() == year
                )
                .flatMap(book -> Flux.just(BookResponseMapper.map(book)));
    }

    @Override
    public Flux<BookResponseDto> retrieveByAuthorAndField(
            @NotBlank String author,
            @NotBlank String field
    ) {
        return repository
                .findAll()
                .filter(e -> e.getAuthor().equals(author)
                        && e.getField().equals(field)
                )
                .flatMap(book -> Flux.just(BookResponseMapper.map(book)));
    }

    @Override
    public Flux<BookResponseDto> retrieveByAuthorAndYear(
            @NotBlank String author,
            int year
    ) {
        return repository
                .findAll()
                .filter(e -> e.getAuthor().equals(author)
                        && e.getPublishingYear() == year
                )
                .flatMap(book -> Flux.just(BookResponseMapper.map(book)));
    }

    @Override
    public Flux<BookResponseDto> retrieveByFieldAndYear(
            @NotBlank String field,
            int year
    ) {
        return repository
                .findAll()
                .filter(e -> e.getField().equals(field)
                        && e.getPublishingYear() == year
                )
                .flatMap(book -> Flux.just(BookResponseMapper.map(book)));
    }
    
}
