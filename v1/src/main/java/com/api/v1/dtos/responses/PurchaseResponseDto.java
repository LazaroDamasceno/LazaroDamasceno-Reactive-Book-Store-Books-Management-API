package com.api.v1.dtos.responses;

public record PurchaseResponseDto(
        BookResponseDto book,
        CustomerResponseDto customer,
        double bookPrice,
        double saleTax,
        double finalPrice,
        String state,
        String createdAt
) {
}
