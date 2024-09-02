package com.api.v1.services.book;

import reactor.core.publisher.Mono;

public interface BooksDeletionService {

    Mono<Void> deleteAll();
    Mono<Void> deleteByIsbn(String isbn);
    Mono<Void> deleteByAuthor(String author);
    Mono<Void> deleteByField(String field);
    Mono<Void> deleteByYear(int year);
    Mono<Void> deleteByVersion(int version);
    Mono<Void> deleteByPublisher(String publisher);

}
