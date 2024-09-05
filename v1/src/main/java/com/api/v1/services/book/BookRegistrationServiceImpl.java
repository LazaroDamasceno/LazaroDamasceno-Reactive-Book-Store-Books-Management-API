package com.api.v1.services.book;

import com.api.v1.builders.book.BookBuilder;
import com.api.v1.domain.entities.Book;
import com.api.v1.domain.repositories.BookRepository;
import com.api.v1.dtos.requests.BookRegistrationRequestDto;
import com.api.v1.dtos.responses.BookResponseDto;
import com.api.v1.exceptions.book.DuplicatedIsbnException;
import com.api.v1.mappers.book.BookResponseMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class BookRegistrationServiceImpl implements BookRegistrationService {

    @Autowired
    private BookRepository repository;

    @Override
    public Mono<BookResponseDto> register(@Valid BookRegistrationRequestDto request) {
        return repository
                .findAll()
                .filter(book -> book.getIsbn().equals(request.isbn()))
                .hasElements()
                .flatMap(exists -> {
                    if (exists) return Mono.error(new DuplicatedIsbnException(request.isbn()));
                    return Mono.defer(() -> {
                        Book newBook = BookBuilder.create().fromDto(request).build();
                        Mono<Book> savedNewBook = repository.save(newBook);
                        return savedNewBook.flatMap(savedBook -> Mono.just(BookResponseMapper.map(savedBook)));
                    });
                });
    }

}
