package com.api.v1.dtos.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UpdateBookRequestDto(
        @NotBlank String title,
        String subtitle,
        @NotBlank String author,
        @NotBlank String field,
        int numberOfPages,
        @Min(1) int version,
        double price
) {
}
