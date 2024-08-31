package com.api.v1.services.purchase;

import reactor.core.publisher.Mono;

public interface PurchaseDeletionService {

    Mono<Void> deleteById(String id);
    Mono<Void> deleteAll();

}
