package com.api.v1.dtos.requests;

import jakarta.validation.constraints.Min;

public record PageableRequestDto(@Min(1) int page, @Min(1) int size) {
}
