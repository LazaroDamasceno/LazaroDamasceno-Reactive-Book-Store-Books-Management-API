package com.api.v1.dtos.requests;

import jakarta.validation.constraints.Min;

public record PaginationRequestDto(
        @Min(1) int page,
        @Min(1) int size
) {
}
