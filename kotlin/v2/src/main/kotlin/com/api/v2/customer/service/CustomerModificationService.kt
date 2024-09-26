package com.api.v2.customer.service

import com.api.v2.customer.dtos.CustomerModificationRequestDto

interface CustomerModificationService {

    suspend fun modify(ssn: String, requestDto: CustomerModificationRequestDto)

}