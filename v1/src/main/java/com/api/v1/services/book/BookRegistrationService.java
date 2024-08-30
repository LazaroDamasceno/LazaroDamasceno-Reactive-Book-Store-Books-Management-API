package com.api.v1.services.book;

import com.api.v1.dtos.requests.NewBookRequestDto;
import com.api.v1.dtos.responses.BookResponseDto;
import reactor.core.publisher.Mono;

public interface BookRegistrationService {

    Mono<BookResponseDto> register(NewBookRequestDto request);

}
