package com.api.v2.customer.dtos

import java.time.LocalDate

data class CustomerModificationRequestDto(
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val birthDate: LocalDate,
    val email: String,
    val gender: String,
    val phoneNumber: String
)
