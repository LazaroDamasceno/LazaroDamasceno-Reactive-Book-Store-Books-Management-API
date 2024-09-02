package com.api.v1.services.purchase;

import com.api.v1.domain.entities.Book;
import com.api.v1.domain.entities.Customer;
import com.api.v1.domain.repositories.PurchaseRepository;
import com.api.v1.dtos.responses.PurchaseResponseDto;
import com.api.v1.mappers.purchase.PurchaseResponseMapper;
import com.api.v1.utils.book.BookFinderUtil;
import com.api.v1.utils.customer.CustomerFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;

@Service
class PurchaseRetrieveServiceImpl implements PurchaseRetrieveService {

    @Autowired
    private PurchaseRepository repository;

    @Autowired
    private BookFinderUtil bookFinderUtil;

    @Autowired
    private CustomerFinderUtil customerFinderUtil;

    @Override
    public Flux<PurchaseResponseDto> retrieveAll() {
        return repository
                .findAll()
                .flatMap(purchase -> Flux.just(PurchaseResponseMapper.map(purchase)));
    }

    @Override
    public Flux<PurchaseResponseDto> retrieveByBook(String isbn) {
        return bookFinderUtil
                .find(isbn)
                .flatMapMany(book -> repository
                                        .findAll()
                                        .filter(e -> e.book().equals(book))
                                        .flatMap(purchase -> Flux.just(PurchaseResponseMapper.map(purchase)))
                );

    }

    @Override
    public Flux<PurchaseResponseDto> retrieveByCustomer(String ssn) {
        return customerFinderUtil
                .find(ssn)
                .flatMapMany(customer -> repository
                                            .findAll()
                                            .filter(e -> e.customer().equals(customer))
                                            .flatMap(purchase -> Flux.just(PurchaseResponseMapper.map(purchase)))
                );
    }

    @Override
    public Flux<PurchaseResponseDto> retrieveByYear(int year) {
        return repository
                .findAll()
                .filter(e -> ZonedDateTime.parse(e.createdAt()).getYear() == year)
                .flatMap(purchase -> Flux.just(PurchaseResponseMapper.map(purchase)));
    }

    @Override
    public Flux<PurchaseResponseDto> retrieveByBookAndCustomerAndYear(
            String isbn,
            String ssn,
            int year
    ) {
        Mono<Book> bookMono = bookFinderUtil.find(isbn);
        Mono<Customer> customerMono = customerFinderUtil.find(ssn);
        return bookMono
                .zipWith(customerMono)
                .flatMapMany(tuple -> repository
                            .findAll()
                            .filter(e -> e.book().equals(tuple.getT1())
                                    && e.customer().equals(tuple.getT2())
                                    && ZonedDateTime.parse(e.createdAt()).getYear() == year
                            )
                            .flatMap(purchase -> Flux.just(PurchaseResponseMapper.map(purchase)))
                );
    }

    @Override
    public Flux<PurchaseResponseDto> retrieveByBookAndCustomer(String isbn, String ssn) {
        Mono<Book> bookMono = bookFinderUtil.find(isbn);
        Mono<Customer> customerMono = customerFinderUtil.find(ssn);
        return bookMono
                .zipWith(customerMono)
                .flatMapMany(tuple -> repository
                        .findAll()
                        .filter(e -> e.book().equals(tuple.getT1())
                                && e.customer().equals(tuple.getT2())
                        )
                        .flatMap(purchase -> Flux.just(PurchaseResponseMapper.map(purchase)))
                );
    }

    @Override
    public Flux<PurchaseResponseDto> retrieveByBookAndYear(
            String isbn,
            int year
    ) {
        return bookFinderUtil
                .find(isbn)
                .flatMapMany(book -> repository
                        .findAll()
                        .filter(e -> e.book().equals(book)
                                && ZonedDateTime.parse(e.createdAt()).getYear() == year
                        )
                        .flatMap(purchase -> Flux.just(PurchaseResponseMapper.map(purchase)))
                );
    }

    @Override
    public Flux<PurchaseResponseDto> retrieveByCustomerAndYear(
            String ssn,
            int year
    ) {
        return customerFinderUtil
                .find(ssn)
                .flatMapMany(customer -> repository
                        .findAll()
                        .filter(e -> e.customer().equals(customer)
                                && ZonedDateTime.parse(e.createdAt()).getYear() == year
                        )
                        .flatMap(purchase -> Flux.just(PurchaseResponseMapper.map(purchase)))
                );
    }

}
