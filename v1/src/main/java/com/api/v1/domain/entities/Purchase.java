package com.api.v1.domain.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "v1_purchases")
public record Purchase(
        @NotNull Book book,
        @NotNull Customer customer,
        double bookPrice,
        double finalPrice,
        @NotBlank String state,
        String createdAt
) {
}
