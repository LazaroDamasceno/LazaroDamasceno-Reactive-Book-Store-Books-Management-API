package com.api.v2.purchases.services

import com.api.v2.book.annotations.ISBN
import com.api.v2.book.utils.BookFinderUtil
import com.api.v2.customer.anotations.SSN
import com.api.v2.customer.utils.CustomerFinderUtil
import com.api.v2.purchases.domain.Purchase
import com.api.v2.purchases.domain.PurchaseRepository
import com.api.v2.purchases.dtos.PurchaseResponseDto
import com.api.v2.purchases.utils.PurchaseOrderNumberGenerator
import com.api.v2.purchases.utils.PurchaseResponseMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.ZoneId

@Service
private class PurchaseServiceImpl: PurchaseService {

    @Autowired
    lateinit var purchaseRepository: PurchaseRepository

    @Autowired
    lateinit var customerFinderUtil: CustomerFinderUtil

    @Autowired
    lateinit var bookFinderUtil: BookFinderUtil

    @Autowired
    lateinit var purchaseResponseMapper: PurchaseResponseMapper

    override suspend fun purchase(ssn: @SSN String, isbn: @ISBN String): PurchaseResponseDto {
        return withContext(Dispatchers.IO) {
            val customer = customerFinderUtil.findOne(ssn)
            val book = bookFinderUtil.findOne(isbn)
            val purchase = Purchase(
                null,
                PurchaseOrderNumberGenerator.generate(),
                customer.id!!,
                book.id!!,
                book.price,
                book.price * 1.2,
                Instant.now(),
                ZoneId.systemDefault()
            )
            val savedPurchase = purchaseRepository.save(purchase)
            purchaseResponseMapper.map(savedPurchase)
        }
    }

}