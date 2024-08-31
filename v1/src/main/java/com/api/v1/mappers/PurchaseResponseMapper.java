package com.api.v1.mappers;

import com.api.v1.domain.entities.Purchase;
import com.api.v1.dtos.responses.PurchaseResponseDto;

public class PurchaseResponseMapper {

    public static PurchaseResponseDto map(Purchase purchase) {
        return new PurchaseResponseDto(
                BookResponseMapper.map(purchase.book()),
                CustomerResponseMapper.map(purchase.customer()),
                purchase.bookPrice(),
                purchase.state(),
                purchase.saleTax(),
                purchase.finalPrice(),
                purchase.createdAt()
        );
    }

}
