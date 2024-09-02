package com.api.v1.domain.entities;

import com.api.v1.utils.book.SaleTaxRatesUtil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.UUID;

@Document(collection = "v1_purchases")
public record Purchase(
        @NotNull Book book,
        @NotNull Customer customer,
        double bookPrice,
        @NotBlank String state,
        Double saleTax,
        Double finalPrice,
        String createdAt
) {

    public Purchase(Book book, Customer customer, double bookPrice, String state) {
        this(
                book,
                customer,
                bookPrice,
                state,
                SaleTaxRatesUtil.map(state),
                (1 + SaleTaxRatesUtil.map(state)) * bookPrice,
                ZonedDateTime.now().toString()
        );
    }

}
