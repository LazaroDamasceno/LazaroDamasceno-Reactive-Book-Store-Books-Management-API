package com.api.v1.services.purchase;

import com.api.v1.domain.entities.Purchase;
import com.api.v1.dtos.responses.PurchaseResponseDto;
import reactor.core.publisher.Mono;

public interface PurchaseRegistrationService {

    Mono<PurchaseResponseDto> register(Purchase purchase);

}
