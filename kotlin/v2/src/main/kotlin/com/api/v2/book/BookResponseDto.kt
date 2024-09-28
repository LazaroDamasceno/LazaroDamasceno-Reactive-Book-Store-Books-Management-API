package com.api.v2.book

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class BookResponseDto(
    val fullTitle: @NotBlank String,
    val isbn: @ISBN String,
    val author: @NotBlank String,
    val field: @NotBlank String,
    val publisher: @NotBlank String,
    val numberOfPages: @Min(1) Int,
    val version: @Min(1) Int,
    val publishingYear: Int
)
