package com.api.v2.customer.service

import com.api.v2.customer.dtos.CustomerResponseDto
import com.api.v2.customer.dtos.CustomerRegistrationRequestDto

interface CustomerRegistrationService {

    suspend fun register(requestDto: CustomerRegistrationRequestDto): CustomerResponseDto

}