package com.api.v1.controllers.purchase;

import com.api.v1.domain.entities.Purchase;
import com.api.v1.dtos.responses.PurchaseResponseDto;
import com.api.v1.services.purchase.PurchaseRegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/purchases")
public class PurchaseRegisterController {

    @Autowired
    private PurchaseRegistrationService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<PurchaseResponseDto> register(@Valid @RequestBody Purchase purchase) {
        return service.register(purchase);
    }

}
