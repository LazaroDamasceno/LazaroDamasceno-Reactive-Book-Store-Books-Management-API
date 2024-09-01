package com.api.v1.services.book;

import com.api.v1.domain.repositories.BookRepository;
import com.api.v1.exceptions.book.BookDataDeletionException;
import com.api.v1.utils.book.BookFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class BooksDeletionServiceImpl implements BooksDeletionService {

    @Autowired
    private BookFinderUtil bookFinderUtil;

    @Autowired
    private BookRepository repository;

    @Override
    public Mono<Void> deleteAll() {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (exists) return repository.deleteAll();
                    return Mono.error(BookDataDeletionException::new);
                });
    }

    @Override
    public Mono<Void> deleteByIsbn(String isbn) {
        return bookFinderUtil
                .find(isbn)
                .flatMap(book -> repository.delete(book));
    }

}
