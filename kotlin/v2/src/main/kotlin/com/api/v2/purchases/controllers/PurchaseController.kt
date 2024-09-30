package com.api.v2.purchases.controllers

import com.api.v2.book.annotations.ISBN
import com.api.v2.customer.anotations.SSN
import com.api.v2.purchases.dtos.PurchaseResponseDto
import com.api.v2.purchases.services.PurchaseDeletionService
import com.api.v2.purchases.services.PurchaseRetrievalService
import com.api.v2.purchases.services.PurchaseService
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v2/purchases")
class PurchaseController {

    @Autowired
    private lateinit var purchaseService: PurchaseService

    @Autowired
    private lateinit var purchaseRetrievalService: PurchaseRetrievalService

    @Autowired
    private lateinit var purchaseDeletionService: PurchaseDeletionService

    @PostMapping("{ssn}/{isbn}")
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun purchase(
        @PathVariable ssn: @SSN String,
        @PathVariable isbn: @ISBN String
    ): PurchaseResponseDto {
        return purchaseService.purchase(ssn, isbn)
    }

    @GetMapping("{orderNumber}")
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun findByOrderNumber(@PathVariable orderNumber: String): PurchaseResponseDto {
        return purchaseRetrievalService.findByOrderNumber(orderNumber)
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun findAll(): Flow<PurchaseResponseDto> {
        return purchaseRetrievalService.findAll()
    }

    @DeleteMapping("{orderNumber}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    suspend fun deleteByOrderNumber(@PathVariable orderNumber: String) {
        return purchaseDeletionService.deleteByOrderNumber(orderNumber)
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    suspend fun deleteAll() {
        return purchaseDeletionService.deleteAll()
    }

}