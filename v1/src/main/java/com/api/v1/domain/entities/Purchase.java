package com.api.v1.domain.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "v1_purchases")
public record Purchase(
        Book dto,
        Customer customer,
        double bookPrince,
        double finalPrice,
        String state,
        String createdAt
) {
}
