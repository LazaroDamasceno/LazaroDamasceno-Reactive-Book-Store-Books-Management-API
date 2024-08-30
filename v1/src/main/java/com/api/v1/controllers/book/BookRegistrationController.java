package com.api.v1.controllers.book;

import com.api.v1.dtos.requests.NewBookRequestDto;
import com.api.v1.dtos.responses.BookResponseDto;
import com.api.v1.services.book.BookRegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/books")
public class BookRegistrationController {

    @Autowired
    private BookRegistrationService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<BookResponseDto> register(@Valid @RequestBody NewBookRequestDto request) {
        return service.register(request);
    }

}
