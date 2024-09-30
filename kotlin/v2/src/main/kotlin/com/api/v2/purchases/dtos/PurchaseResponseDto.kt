package com.api.v2.purchases.dtos

import com.api.v2.book.dtos.BookResponseDto
import com.api.v2.customer.dtos.CustomerResponseDto
import java.math.BigInteger

data class PurchaseResponseDto(
    var orderNumber: BigInteger,
    var customer: CustomerResponseDto,
    var book: BookResponseDto,
    var price: Double,
    var finalPrice: Double,
)
