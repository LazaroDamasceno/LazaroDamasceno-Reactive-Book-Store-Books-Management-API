package com.api.v1.dtos.responses;

public record BookResponseDto(
        String fullTitle,
        String isbn,
        String author,
        String field,
        int numberOfPages,
        int version,
        double price,
        String publisher
) {
}
