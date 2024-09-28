package com.api.v2.customer.dtos

import com.api.v2.customer.anotations.SSN
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class CustomerRegistrationRequestDto(
    val firstName: @NotBlank String,
    val middleName: String?,
    val lastName: @NotBlank String,
    val ssn: @SSN String,
    val birthDate: @NotNull LocalDate,
    val email: @NotBlank @Email String,
    val gender: @NotBlank @Size(min=1) String,
    val phoneNumber: @NotBlank @Size(min=10, max=10) String
)
