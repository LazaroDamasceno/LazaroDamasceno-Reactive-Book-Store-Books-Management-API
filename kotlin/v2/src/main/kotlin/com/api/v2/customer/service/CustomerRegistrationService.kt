package com.api.v2.customer.service

import com.api.v2.customer.dtos.CustomerResponseDto
import com.api.v2.customer.domain.Customer

interface CustomerRegistrationService {

    suspend fun register(customer: Customer): CustomerResponseDto

}