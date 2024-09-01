package com.api.v1.services.purchase;

import com.api.v1.domain.entities.Book;
import com.api.v1.domain.entities.Customer;
import com.api.v1.domain.repositories.PurchaseRepository;
import com.api.v1.dtos.requests.PaginationRequestDto;
import com.api.v1.dtos.responses.PurchaseResponseDto;
import com.api.v1.mappers.PurchaseResponseMapper;
import com.api.v1.utils.BookFinderUtil;
import com.api.v1.utils.CustomerFinderUtil;
import com.api.v1.utils.PageableUtil;
import jakarta.validation.Valid;
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
    public Flux<PurchaseResponseDto> retrieveAll(@Valid PaginationRequestDto pagination) {
        return repository
                .findBy(PageableUtil.get(pagination))
                .flatMap(purchase -> Flux.just(PurchaseResponseMapper.map(purchase)));
    }

    @Override
    public Flux<PurchaseResponseDto> retrieveByBook(String isbn, @Valid PaginationRequestDto pagination) {
        return bookFinderUtil
                .find(isbn)
                .flatMapMany(book -> repository
                                        .findBy(PageableUtil.get(pagination))
                                        .filter(e -> e.book().equals(book))
                                        .flatMap(purchase -> Flux.just(PurchaseResponseMapper.map(purchase)))
                );

    }

    @Override
    public Flux<PurchaseResponseDto> retrieveByCustomer(String ssn, @Valid PaginationRequestDto pagination) {
        return customerFinderUtil
                .find(ssn)
                .flatMapMany(customer -> repository
                                            .findBy(PageableUtil.get(pagination))
                                            .filter(e -> e.customer().equals(customer))
                                            .flatMap(purchase -> Flux.just(PurchaseResponseMapper.map(purchase)))
                );
    }

    @Override
    public Flux<PurchaseResponseDto> retrieveByYear(int year, @Valid PaginationRequestDto pagination) {
        return repository
                .findBy(PageableUtil.get(pagination))
                .filter(e -> ZonedDateTime.parse(e.createdAt()).getYear() == year)
                .flatMap(purchase -> Flux.just(PurchaseResponseMapper.map(purchase)));
    }

    @Override
    public Flux<PurchaseResponseDto> retrieveByBookAndCustomerAndYear(
            String isbn,
            String ssn,
            int year,
            @Valid PaginationRequestDto pagination
    ) {
        Mono<Book> bookMono = bookFinderUtil.find(isbn);
        Mono<Customer> customerMono = customerFinderUtil.find(ssn);
        return bookMono
                .zipWith(customerMono)
                .flatMapMany(tuple -> repository
                            .findBy(PageableUtil.get(pagination))
                            .filter(e -> e.book().equals(tuple.getT1())
                                    && e.customer().equals(tuple.getT2())
                                    && ZonedDateTime.parse(e.createdAt()).getYear() == year
                            )
                            .flatMap(purchase -> Flux.just(PurchaseResponseMapper.map(purchase)))
                );
    }

    @Override
    public Flux<PurchaseResponseDto> retrieveByBookAndCustomer(
            String isbn,
            String ssn,
            @Valid PaginationRequestDto pagination
    ) {
        Mono<Book> bookMono = bookFinderUtil.find(isbn);
        Mono<Customer> customerMono = customerFinderUtil.find(ssn);
        return bookMono
                .zipWith(customerMono)
                .flatMapMany(tuple -> repository
                        .findBy(PageableUtil.get(pagination))
                        .filter(e -> e.book().equals(tuple.getT1())
                                && e.customer().equals(tuple.getT2())
                        )
                        .flatMap(purchase -> Flux.just(PurchaseResponseMapper.map(purchase)))
                );
    }

    @Override
    public Flux<PurchaseResponseDto> retrieveByBookAndYear(
            String isbn,
            int year,
            @Valid PaginationRequestDto pagination
    ) {
        return bookFinderUtil
                .find(isbn)
                .flatMapMany(book -> repository
                        .findBy(PageableUtil.get(pagination))
                        .filter(e -> e.book().equals(book)
                                && ZonedDateTime.parse(e.createdAt()).getYear() == year
                        )
                        .flatMap(purchase -> Flux.just(PurchaseResponseMapper.map(purchase)))
                );
    }

    @Override
    public Flux<PurchaseResponseDto> retrieveByCustomerAndYear(
            String ssn,
            int year,
            @Valid PaginationRequestDto pagination
    ) {
        return customerFinderUtil
                .find(ssn)
                .flatMapMany(customer -> repository
                        .findBy(PageableUtil.get(pagination))
                        .filter(e -> e.customer().equals(customer)
                                && ZonedDateTime.parse(e.createdAt()).getYear() == year
                        )
                        .flatMap(purchase -> Flux.just(PurchaseResponseMapper.map(purchase)))
                );
    }

}
