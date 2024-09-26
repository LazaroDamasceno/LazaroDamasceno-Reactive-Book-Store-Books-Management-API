package com.api.v2

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

@Document(collection = "v2_customers")
data class Customer(
    @Id
    var id: UUID,
    @Field
    var firstName: String,
    @Field
    var middleName: String?,
    @Field
    var lastName: String,
    @Field
    val ssn: String,
    @Field
    var birthDate: LocalDate,
    @Field
    var email: String,
    @Field
    var gender: String,
    @Field
    var phoneNumber: String,
    @Field
    val createdAt: Instant,
    @Field
    val creationZoneId: ZoneId,
    @Field
    var modifiedAt: Instant?,
    @Field
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
        phoneNumber: String
    ): this(
        UUID.randomUUID(),
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
