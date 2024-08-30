package com.api.v1.controllers.book;

import com.api.v1.services.book.BooksDeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/books")
public class BooksDeletionController {

    @Autowired
    private BooksDeletionService service;

    @DeleteMapping()
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAll() {
        return service.deleteAll();
    }

    @DeleteMapping("{isbn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteByIsbn(@PathVariable String isbn) {
        return service.deleteByIsbn(isbn);
    }

}
