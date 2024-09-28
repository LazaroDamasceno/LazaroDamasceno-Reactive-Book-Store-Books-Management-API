package com.api.v2.customer.service

import com.api.v2.customer.domain.Customer
import com.api.v2.customer.dtos.CustomerModificationRequestDto
import com.api.v2.customer.dtos.CustomerRegistrationRequestDto
import com.api.v2.customer.dtos.CustomerResponseDto

interface CustomerRegistrationService {

    suspend fun register(requestDto: CustomerRegistrationRequestDto): CustomerResponseDto
    suspend fun register(existingCustomer : Customer, requestDto: CustomerModificationRequestDto): CustomerResponseDto

}