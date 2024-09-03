package com.api.v1.dtos.requests;

import com.api.v1.annotations.ISBN;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record BookRegistrationRequestDto(
        @NotBlank String title,
        String subtitle,
        @ISBN String isbn,
        @NotBlank String author,
        @NotBlank String field,
        int numberOfPages,
        @Min(1) int version,
        double price,
        @NotBlank String publisher,
        int publishingYear
) {
}
