package com.api.v1.dtos.responses;

public record PurchaseResponseDto(
        BookResponseDto book,
        CustomerResponseDto customer,
        double bookPrice,
        String state,
        double saleTax,
        double finalPrice,
        String createdAt
) {
}
