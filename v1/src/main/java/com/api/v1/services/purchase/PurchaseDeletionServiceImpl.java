package com.api.v1.services.purchase;

import com.api.v1.domain.entities.Book;
import com.api.v1.domain.entities.Customer;
import com.api.v1.domain.repositories.PurchaseRepository;
import com.api.v1.exceptions.PurchaseWasNotFoundException;
import com.api.v1.utils.BookFinderUtil;
import com.api.v1.utils.CustomerFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
class PurchaseDeletionServiceImpl implements PurchaseDeletionService {

    @Autowired
    private PurchaseRepository repository;

    @Autowired
    private BookFinderUtil bookFinderUtil;

    @Autowired
    private CustomerFinderUtil customerFinderUtil;

    @Override
    public Mono<Void> deleteById(String id) {
        return repository
                .findById(UUID.fromString(id))
                .switchIfEmpty(Mono.error(PurchaseWasNotFoundException::new))
                .flatMap(purchase -> repository.delete(purchase));
    }

    @Override
    public Mono<Void> deleteAll() {
        return repository.deleteAll();
    }

    @Override
    public Flux<Void> deleteByCustomer(String ssn) {
        return customerFinderUtil
                .find(ssn)
                .flatMapMany(customer -> repository
                            .findAll()
                            .filter(e -> e.customer().equals(customer))
                )
                .flatMap(purchase -> repository.delete(purchase));
    }

    @Override
    public Flux<Void> deleteByBook(String isbn) {
        return bookFinderUtil
                .find(isbn)
                .flatMapMany(book -> repository
                        .findAll()
                        .filter(e -> e.book().equals(book))
                )
                .flatMap(purchase -> repository.delete(purchase));
    }

    @Override
    public Flux<Void> deleteByYear(int year) {
        return repository
                .findAll()
                .filter(e -> ZonedDateTime.parse(e.createdAt()).getYear() == year)
                .flatMap(purchase -> repository.delete(purchase));
    }

    @Override
    public Flux<Void> deleteByCustomerAndBookAndYear(String ssn, String isbn, int year) {
        Mono<Customer> customerMono = customerFinderUtil.find(ssn);
        Mono<Book> bookMono = bookFinderUtil.find(isbn);
        return customerMono
                .zipWith(bookMono)
                .flatMapMany(tuple -> repository
                            .findAll()
                            .filter(e -> e.book().equals(tuple.getT2())
                                    && e.customer().equals(tuple.getT1())
                                    && ZonedDateTime.now().getYear() == year
                            )
                            .flatMap(purchase -> repository.delete(purchase))
                );
    }

    @Override
    public Flux<Void> deleteByCustomerAndBook(String ssn, String isbn) {
        Mono<Customer> customerMono = customerFinderUtil.find(ssn);
        Mono<Book> bookMono = bookFinderUtil.find(isbn);
        return customerMono
                .zipWith(bookMono)
                .flatMapMany(tuple -> repository
                        .findAll()
                        .filter(e -> e.book().equals(tuple.getT2())
                                && e.customer().equals(tuple.getT1())
                        )
                        .flatMap(purchase -> repository.delete(purchase))
                );
    }

    @Override
    public Flux<Void> deleteByCustomerAndYear(String ssn, int year) {
        return customerFinderUtil
                .find(ssn)
                .flatMapMany(customer -> repository
                        .findAll()
                        .filter(e -> e.customer().equals(customer)
                                && ZonedDateTime.now().getYear() == year
                        )
                        .flatMap(purchase -> repository.delete(purchase))
                );
    }

    @Override
    public Flux<Void> deleteByBookAndYear(String isbn, int year) {
        return bookFinderUtil
                .find(isbn)
                .flatMapMany(book -> repository
                        .findAll()
                        .filter(e -> e.book().equals(book)
                                && ZonedDateTime.now().getYear() == year
                        )
                        .flatMap(purchase -> repository.delete(purchase))
                );
    }

}
