package com.api.v1.domain.repositories;

import com.api.v1.domain.entities.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface BookRepository extends ReactiveCrudRepository<Book, UUID> {

    Flux<Book> findBy(Pageable pageable);

}
