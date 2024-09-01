package com.api.v1.services.purchase;

import com.api.v1.domain.entities.Book;
import com.api.v1.domain.entities.Customer;
import com.api.v1.domain.repositories.PurchaseRepository;
import com.api.v1.exceptions.purchase.PurchaseDataDeletionException;
import com.api.v1.exceptions.purchase.PurchaseNotFoundException;
import com.api.v1.utils.book.BookFinderUtil;
import com.api.v1.utils.customer.CustomerFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
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
                .switchIfEmpty(Mono.error(PurchaseNotFoundException::new))
                .flatMap(purchase -> repository.delete(purchase));
    }

    @Override
    public Mono<Void> deleteAll() {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (exists) return repository.deleteAll();
                    return Mono.error(PurchaseDataDeletionException::new);
                });
    }

    @Override
    public Mono<Void> deleteByCustomer(String ssn) {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (!exists) return Mono.error(PurchaseDataDeletionException::new);
                    return customerFinderUtil
                            .find(ssn)
                            .flatMapMany(customer -> repository
                                    .findAll()
                                    .filter(e -> e.customer().equals(customer))
                            )
                            .flatMap(purchase -> repository.delete(purchase))
                            .then();
                });
    }

    @Override
    public Mono<Void> deleteByBook(String isbn) {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (!exists) return Mono.error(PurchaseDataDeletionException::new);
                    return bookFinderUtil
                            .find(isbn)
                            .flatMapMany(book -> repository
                                    .findAll()
                                    .filter(e -> e.book().equals(book))
                            )
                            .flatMap(purchase -> repository.delete(purchase))
                            .then();
                });

    }

    @Override
    public Mono<Void> deleteByYear(int year) {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (!exists) return Mono.error(PurchaseDataDeletionException::new);
                    return repository
                            .findAll()
                            .filter(e -> ZonedDateTime.parse(e.createdAt()).getYear() == year)
                            .flatMap(purchase -> repository.delete(purchase))
                            .then();
                });
    }

    @Override
    public Mono<Void> deleteByCustomerAndBookAndYear(String ssn, String isbn, int year) {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (!exists) return Mono.error(PurchaseDataDeletionException::new);
                    return Mono.defer(() -> {
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
                                )
                                .then();
                    });
                });
    }

    @Override
    public Mono<Void> deleteByCustomerAndBook(String ssn, String isbn) {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (!exists) return Mono.error(PurchaseDataDeletionException::new);
                    return Mono.defer(() -> {
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
                                )
                                .then();
                    });
                });

    }

    @Override
    public Mono<Void> deleteByCustomerAndYear(String ssn, int year) {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (!exists) return Mono.error(PurchaseDataDeletionException::new);
                    return customerFinderUtil
                                .find(ssn)
                                .flatMapMany(customer -> repository
                                        .findAll()
                                        .filter(e -> e.customer().equals(customer)
                                                && ZonedDateTime.now().getYear() == year
                                        )
                                        .flatMap(purchase -> repository.delete(purchase))
                                )
                                .then();
                });

    }

    @Override
    public Mono<Void> deleteByBookAndYear(String isbn, int year) {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (!exists) return Mono.error(PurchaseDataDeletionException::new);
                    return bookFinderUtil
                            .find(isbn)
                            .flatMapMany(book -> repository
                                    .findAll()
                                    .filter(e -> e.book().equals(book)
                                            && ZonedDateTime.now().getYear() == year
                                    )
                                    .flatMap(purchase -> repository.delete(purchase))
                            )
                            .then();
                });

    }

}
