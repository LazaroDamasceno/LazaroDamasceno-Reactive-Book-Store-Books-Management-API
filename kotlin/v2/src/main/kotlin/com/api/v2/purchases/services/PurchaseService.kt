package com.api.v2.purchases.services

import com.api.v2.purchases.dtos.PurchaseResponseDto

interface PurchaseService {

    suspend fun purchase(ssn: String, isbn: String): PurchaseResponseDto

}