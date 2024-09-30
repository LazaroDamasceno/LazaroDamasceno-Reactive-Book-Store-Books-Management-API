package com.api.v2.purchases.services

import com.api.v2.exceptions.EmptyEntityException
import com.api.v2.purchases.domain.PurchaseRepository
import com.api.v2.purchases.dtos.PurchaseResponseDto
import com.api.v2.purchases.utils.PurchaseFinderUtil
import com.api.v2.purchases.utils.PurchaseResponseMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class PurchaseRetrievalServiceImpl: PurchaseRetrievalService {

    @Autowired
    lateinit var purchaseFinderUtil: PurchaseFinderUtil

    @Autowired
    lateinit var purchaseRepository: PurchaseRepository

    @Autowired
    lateinit var purchaseResponseMapper: PurchaseResponseMapper

    override suspend fun findByOrderNumber(orderNumber: String): PurchaseResponseDto {
        return withContext(Dispatchers.IO) {
            val purchase = purchaseFinderUtil.find(orderNumber)
            purchaseResponseMapper.map(purchase)
        }
    }

    override suspend fun findAll(): Flow<PurchaseResponseDto> {
        return withContext(Dispatchers.IO) {
            val purchases = purchaseRepository.findAll()
            if (purchases.count() == 0) throw EmptyEntityException()
            purchases.map { e -> purchaseResponseMapper.map(e) }
        }
    }

}