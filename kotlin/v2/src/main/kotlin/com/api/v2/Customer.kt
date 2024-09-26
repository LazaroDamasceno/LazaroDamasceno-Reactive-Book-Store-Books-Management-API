package com.api.v2

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

@Table("v2_customers")
data class Customer(
    @Id
    var id: String,
    @Column
    var firstName: String,
    @Column
    var middleName: String?,
    @Column
    var lastName: String,
    @Column
    val ssn: String,
    @Column
    var birthDate: LocalDate,
    @Column
    var email: String,
    @Column
    var gender: String,
    @Column
    var phoneNumber: String,
    @Column
    val createdAt: Instant,
    @Column
    val creationZoneId: ZoneId,
    @Column
    var modifiedAt: Instant?,
    @Column
    val modificationZoneId: ZoneId?
) {

    constructor(
        firstName: String,
        middleName: String?,
        lastName: String,
        ssn: String,
        birthDate: LocalDate,
        email: String,
        gender: String,
        phoneNumber: String,
    ): this(
        UUID.randomUUID().toString(),
        firstName,
        middleName,
        lastName,
        ssn,
        birthDate,
        email,
        gender,
        phoneNumber,
        Instant.now(),
        ZoneId.systemDefault(),
        null,
        null
    )

    fun fullName(): String {
        if (middleName.isNullOrEmpty()) {
            return "$firstName $lastName"
        }
        return "$firstName $middleName $lastName"
    }

}
