package com.api.v2.customer.dtos

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class CustomerModificationRequestDto(
    val firstName: @NotBlank String,
    val middleName: String?,
    val lastName: @NotBlank String,
    val birthDate: @NotNull LocalDate,
    val email: @Email @NotBlank String,
    val gender: @Size(min=1) @NotBlank String,
    val phoneNumber: @Size(min=10, max=10) @NotBlank String
)
