package com.api.v2.customer.service

import com.api.v2.customer.domain.Customer
import com.api.v2.customer.dtos.CustomerModificationRequestDto
import com.api.v2.customer.dtos.CustomerResponseDto

interface CustomerModificationService {

    suspend fun modify(ssn: String, requestDto: CustomerModificationRequestDto): Customer

}