package com.api.v1.controllers.book;

import com.api.v1.dtos.requests.UpdateBookRequestDto;
import com.api.v1.dtos.responses.BookResponseDto;
import com.api.v1.services.book.BookUpdateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/books")
public class BookUpdateController {

    @Autowired
    private BookUpdateService service;

    @PutMapping("{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<BookResponseDto> update(@PathVariable String isbn, @Valid @RequestBody UpdateBookRequestDto request) {
        return service.update(isbn, request);
    }

}
