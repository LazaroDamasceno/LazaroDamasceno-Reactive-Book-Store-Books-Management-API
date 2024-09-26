package com.api.v1.mappers.purchase;

import com.api.v1.domain.entities.Purchase;
import com.api.v1.dtos.responses.PurchaseResponseDto;
import com.api.v1.mappers.book.BookResponseMapper;
import com.api.v1.mappers.customer.CustomerResponseMapper;

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
