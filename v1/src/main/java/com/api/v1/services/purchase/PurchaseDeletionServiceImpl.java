package com.api.v1.services.purchase;

import com.api.v1.domain.repositories.PurchaseRepository;
import com.api.v1.exceptions.PurchaseWasNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
class PurchaseDeletionServiceImpl implements PurchaseDeletionService {

    @Autowired
    private PurchaseRepository repository;

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

}
