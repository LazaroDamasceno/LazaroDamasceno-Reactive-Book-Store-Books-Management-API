package com.api.v1.utils;

import com.api.v1.domain.entities.Book;
import com.api.v1.domain.repositories.BookRepository;
import com.api.v1.exceptions.book.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class BookFinderUtil {

    @Autowired
    private BookRepository repository;

    public Mono<Book> find(String isbn) {
        return repository
                .findAll()
                .filter(e -> e.getIsbn().equals(isbn)
                        && e.getArchivedAt() == null
                )
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(new BookNotFoundException(isbn)));
    }

}
