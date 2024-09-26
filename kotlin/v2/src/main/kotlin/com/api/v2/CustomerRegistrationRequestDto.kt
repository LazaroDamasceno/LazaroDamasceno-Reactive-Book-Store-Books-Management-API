package com.api.v2

import java.time.LocalDate

data class CustomerRegistrationRequestDto(
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val ssn: String,
    val birthDate: LocalDate,
    val email: String,
    val gender: String,
    val phoneNumber: String,
)
