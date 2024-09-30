package com.api.v2.purchases.services

import com.api.v2.purchases.dtos.PurchaseResponseDto
import kotlinx.coroutines.flow.Flow

interface PurchaseRetrievalService {

    suspend fun findByOrderNumber(orderNumber: String): PurchaseResponseDto
    suspend fun findAll(): Flow<PurchaseResponseDto>

}