package com.api.v1.domain.entities;

import com.api.v1.utils.book.SaleTaxRatesUtil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

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

    public Purchase(Book book, Customer customer, String state) {
        this(
                book,
                customer,
                book.getPrice(),
                state,
                SaleTaxRatesUtil.map(state),
                (1 + SaleTaxRatesUtil.map(state)) * book.getPrice(),
                ZonedDateTime.now().toString()
        );
    }

}
