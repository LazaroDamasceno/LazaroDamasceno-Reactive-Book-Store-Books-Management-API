package com.api.v1.services.book;

import com.api.v1.builders.book.BookBuilder;
import com.api.v1.domain.entities.Book;
import com.api.v1.domain.repositories.BookRepository;
import com.api.v1.dtos.requests.NewBookRequestDto;
import com.api.v1.dtos.responses.BookResponseDto;
import com.api.v1.mappers.book.BookResponseMapper;
import com.api.v1.utils.book.BookFinderUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class BookUpdateServiceImpl implements BookUpdateService {

    @Autowired
    private BookFinderUtil bookFinderUtil;

    @Autowired
    private BookRepository repository;

    @Override
    public Mono<BookResponseDto> update(@Valid NewBookRequestDto request) {
        return bookFinderUtil
                .find(request.isbn())
                .flatMap(existingBook -> {
                    existingBook.archive();
                    return repository.save(existingBook);
                })
                .then(Mono.defer(() -> {
                    Book updatedBook = BookBuilder.create().fromDto(request).build();
                    return repository
                            .save(updatedBook)
                            .flatMap(updateBook -> Mono.just(BookResponseMapper.map(updateBook)));
                }));
    }

}
