package com.api.v2.customer.service

import com.api.v2.customer.dtos.CustomerResponseDto
import kotlinx.coroutines.flow.Flow

interface CustomerRetrievalService {

    suspend fun findBySsn(ssn: String): CustomerResponseDto
    suspend fun findAll(): Flow<CustomerResponseDto>

}