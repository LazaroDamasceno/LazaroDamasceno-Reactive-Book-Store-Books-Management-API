package com.api.v1.services.book;

import com.api.v1.domain.repositories.BookRepository;
import com.api.v1.exceptions.book.BookDataDeletionException;
import com.api.v1.utils.book.BookFinderUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.annotations.ISBN;

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
    public Mono<Void> deleteByIsbn(@ISBN String isbn) {
        return bookFinderUtil
                .find(isbn)
                .flatMap(book -> repository
                        .findAll()
                        .filter(e -> e.getIsbn().equals(isbn))
                        .flatMap(repository::delete)
                        .then()
                );
    }

    @Override
    public Mono<Void> deleteByAuthor(String author) {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (!exists) return Mono.error(BookDataDeletionException::new);
                    return repository
                            .findAll()
                            .filter(e -> e.getAuthor().equals(author))
                            .flatMap(book -> repository.delete(book))
                            .then();
                });
    }

    @Override
    public Mono<Void> deleteByField(String field) {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (!exists) return Mono.error(BookDataDeletionException::new);
                    return repository
                            .findAll()
                            .filter(e -> e.getField().equals(field))
                            .flatMap(book -> repository.delete(book))
                            .then();
                });
    }

    @Override
    public Mono<Void> deleteByYear(int year) {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (!exists) return Mono.error(BookDataDeletionException::new);
                    return repository
                            .findAll()
                            .filter(e -> e.getPublishingYear() == year)
                            .flatMap(book -> repository.delete(book))
                            .then();
                });
    }

    @Override
    public Mono<Void> deleteByVersion(int version) {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (!exists) return Mono.error(BookDataDeletionException::new);
                    return repository
                            .findAll()
                            .filter(e -> e.getVersion() == version)
                            .flatMap(book -> repository.delete(book))
                            .then();
                });
    }

    @Override
    public Mono<Void> deleteByPublisher(String publisher) {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (!exists) return Mono.error(BookDataDeletionException::new);
                    return repository
                            .findAll()
                            .filter(e -> e.getPublisher().equals(publisher))
                            .flatMap(book -> repository.delete(book))
                            .then();
                });
    }

}
