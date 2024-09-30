package com.api.v2.purchases.services

interface PurchaseDeletionService {

    suspend fun deleteByOrderNumber(orderNumber: String)
    suspend fun deleteAll()

}