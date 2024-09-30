package com.api.v2.purchases.controllers

import com.api.v2.book.annotations.ISBN
import com.api.v2.customer.anotations.SSN
import com.api.v2.purchases.dtos.PurchaseResponseDto
import com.api.v2.purchases.services.PurchaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v2/purchases")
class PurchaseController {

    @Autowired
    private lateinit var purchaseService: PurchaseService

    @PostMapping("{ssn}/{isbn}")
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun purchase(
        @PathVariable ssn: @SSN String,
        @PathVariable isbn: @ISBN String
    ): PurchaseResponseDto {
        return purchaseService.purchase(ssn, isbn)
    }

}