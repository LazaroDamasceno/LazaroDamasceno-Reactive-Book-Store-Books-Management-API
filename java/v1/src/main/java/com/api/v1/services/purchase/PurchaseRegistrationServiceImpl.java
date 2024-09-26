package com.api.v1.services.purchase;

import com.api.v1.domain.entities.Purchase;
import com.api.v1.domain.repositories.PurchaseRepository;
import com.api.v1.dtos.responses.PurchaseResponseDto;
import com.api.v1.mappers.purchase.PurchaseResponseMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class PurchaseRegistrationServiceImpl implements PurchaseRegistrationService {

    @Autowired
    private PurchaseRepository repository;

    @Override
    public Mono<PurchaseResponseDto> register(@Valid Purchase purchase) {
        return repository
                .save(purchase)
                .flatMap(savedPurchase -> Mono.just(PurchaseResponseMapper.map(savedPurchase)));
    }

}
