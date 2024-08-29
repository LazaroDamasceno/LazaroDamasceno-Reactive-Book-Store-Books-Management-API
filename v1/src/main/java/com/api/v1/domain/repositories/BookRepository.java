package com.api.v1.domain.repositories;

import com.api.v1.domain.entities.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface BookRepository extends ReactiveCrudRepository<Book, UUID> {
}
