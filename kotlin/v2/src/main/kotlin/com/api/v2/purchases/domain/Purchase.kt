package com.api.v2.purchases.domain

import com.api.v2.book.domain.Book
import com.api.v2.customer.domain.Customer
import com.api.v2.purchases.utils.PurchaseOrderNumberGenerator
import jakarta.validation.constraints.NotNull
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigInteger
import java.time.Instant
import java.time.ZoneId
import java.util.*

@Table("purchases")
data class Purchase(
    @Id
    var id: UUID?,
    var orderNumber: BigInteger,
    var customerId: UUID,
    var bookId: UUID,
    var price: Double,
    var finalPrice: Double,
    var createdAt: Instant = Instant.now(),
    var creationZoneId: ZoneId = ZoneId.systemDefault()
) {

    constructor(customer: @NotNull Customer, book: @NotNull Book) : this(
        null,
        PurchaseOrderNumberGenerator.generate(),
        customer.id!!,
        book.id!!,
        book.price,
        book.price * 1.2,
        Instant.now(),
        ZoneId.systemDefault()
    )

}
