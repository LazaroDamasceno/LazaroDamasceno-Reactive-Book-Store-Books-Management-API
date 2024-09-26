package com.api.v1.services.book;

import com.api.v1.domain.repositories.BookRepository;
import com.api.v1.dtos.requests.BookRegistrationRequestDto;
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
    public Mono<BookResponseDto> update(@Valid BookRegistrationRequestDto request) {
        return bookFinderUtil
                .find(request.isbn())
                .flatMap(existingBook -> {
                    existingBook.update(request);
                    return repository.save(existingBook);
                })
                .flatMap(book -> Mono.just(BookResponseMapper.map(book)));
    }

}
