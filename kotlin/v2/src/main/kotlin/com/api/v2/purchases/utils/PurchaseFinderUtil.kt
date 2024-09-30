package com.api.v2.purchases.utils

import com.api.v2.purchases.domain.Purchase
import com.api.v2.purchases.domain.PurchaseRepository
import com.api.v2.purchases.exceptions.PurchaseNotFoundException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.math.BigInteger

@Component
class PurchaseFinderUtil {

    @Autowired
    private lateinit var purchaseRepository: PurchaseRepository

    suspend fun find(orderNumber: String): Purchase {
        return withContext(Dispatchers.IO) {
            val purchase = purchaseRepository
                .findAll()
                .filter { e -> e.orderNumber == BigInteger(orderNumber) }
                .singleOrNull()
            if (purchase == null) throw PurchaseNotFoundException(orderNumber)
            purchase
        }
    }

}