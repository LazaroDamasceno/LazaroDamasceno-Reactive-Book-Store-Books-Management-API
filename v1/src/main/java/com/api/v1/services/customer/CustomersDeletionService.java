package com.api.v1.services.customer;

import reactor.core.publisher.Mono;

public interface CustomersDeletionService {

    Mono<Void> deleteAll();

    Mono<Void> deleteBySsn(String ssn);

}
