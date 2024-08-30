package com.api.v1.services.book;

import reactor.core.publisher.Mono;

public interface BooksDeletionService {

    Mono<Void> deleteAll();

    Mono<Void> deleteByIsbn(String isbn);

}
