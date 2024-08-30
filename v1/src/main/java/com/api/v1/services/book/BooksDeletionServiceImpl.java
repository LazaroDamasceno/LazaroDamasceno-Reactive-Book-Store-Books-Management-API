package com.api.v1.services.book;

import com.api.v1.domain.repositories.BookRepository;
import com.api.v1.utils.BookFinderUtil;
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
        return repository.deleteAll();
    }

    @Override
    public Mono<Void> deleteByIsbn(String isbn) {
        return bookFinderUtil
                .find(isbn)
                .flatMap(book -> repository.delete(book));
    }

}
