package com.api.v2.purchases.services

import com.api.v2.exceptions.EmptyEntityException
import com.api.v2.purchases.domain.PurchaseRepository
import com.api.v2.purchases.utils.PurchaseFinderUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class PurchaseDeletionServiceImpl: PurchaseDeletionService {

    @Autowired
    lateinit var purchaseFinderUtil: PurchaseFinderUtil

    @Autowired
    lateinit var purchaseRepository: PurchaseRepository

    override suspend fun deleteByOrderNumber(orderNumber: String) {
        return withContext(Dispatchers.IO) {
            val purchase = purchaseFinderUtil.find(orderNumber)
            purchaseRepository.delete(purchase)
        }
    }

    override suspend fun deleteAll() {
        return withContext(Dispatchers.IO) {
            if (purchaseRepository.count() == 0L) {
                throw EmptyEntityException()
            }
            purchaseRepository.deleteAll()
        }
    }
}