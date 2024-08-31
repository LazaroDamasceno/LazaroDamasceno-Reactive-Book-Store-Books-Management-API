package com.api.v1.services.book;

import com.api.v1.domain.entities.Book;
import com.api.v1.domain.repositories.BookRepository;
import com.api.v1.dtos.requests.UpdateBookRequestDto;
import com.api.v1.dtos.responses.BookResponseDto;
import com.api.v1.mappers.BookResponseMapper;
import com.api.v1.utils.BookFinderUtil;
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
    public Mono<BookResponseDto> update(String isbn, @Valid UpdateBookRequestDto request) {
        return bookFinderUtil
                .find(isbn)
                .flatMap(existingBook -> {
                    existingBook.archive();
                    return repository.save(existingBook);
                })
                .flatMap(archivedBook -> {
                    Book updatedBook = archivedBook.update(request);
                    return repository.save(updatedBook);
                })
                .flatMap(updateBook -> Mono.just(BookResponseMapper.map(updateBook)));
    }

}
