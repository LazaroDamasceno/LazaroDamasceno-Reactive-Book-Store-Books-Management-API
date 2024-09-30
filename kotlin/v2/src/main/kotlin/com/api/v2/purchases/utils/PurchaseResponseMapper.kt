package com.api.v2.purchases.utils

import com.api.v2.book.domain.BookRepository
import com.api.v2.book.utils.BookResponseMapper
import com.api.v2.customer.domain.CustomerRepository
import com.api.v2.customer.utils.CustomerResponseMapperUtil
import com.api.v2.purchases.dtos.PurchaseResponseDto
import com.api.v2.purchases.domain.Purchase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PurchaseResponseMapper {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @Autowired
    private lateinit var bookRepository: BookRepository

    suspend fun map(purchase: Purchase): PurchaseResponseDto {
        return PurchaseResponseDto(
                purchase.orderNumber,
                CustomerResponseMapperUtil.map(customerRepository.findById(purchase.customer)!!),
                BookResponseMapper.map(bookRepository.findById(purchase.book)!!),
                purchase.price,
                purchase.finalPrice
        )
    }

}