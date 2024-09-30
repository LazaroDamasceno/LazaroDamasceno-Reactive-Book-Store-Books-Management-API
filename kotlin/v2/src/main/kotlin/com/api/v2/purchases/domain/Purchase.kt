package com.api.v2.purchases.domain

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
    var createdAt: Instant,
    var creationZoneId: ZoneId
)
