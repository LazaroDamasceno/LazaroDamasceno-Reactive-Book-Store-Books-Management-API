package com.api.v1.services.book;

import com.api.v1.dtos.requests.UpdateBookRequestDto;
import com.api.v1.dtos.responses.BookResponseDto;
import reactor.core.publisher.Mono;

public interface BookUpdateService {

    Mono<BookResponseDto> update(String isbn, UpdateBookRequestDto request);

}
