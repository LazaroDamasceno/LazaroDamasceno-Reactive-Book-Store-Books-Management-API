package com.api.v2.customer.domain

import com.api.v2.customer.anotations.SSN
import com.api.v2.customer.dtos.CustomerModificationRequestDto
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
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
    var modificationZoneId: ZoneId?
) {

    constructor(
        firstName: @NotBlank String,
        middleName: String?,
        lastName: @NotBlank String,
        ssn: @SSN String,
        birthDate: @NotNull LocalDate,
        email: @Email @NotBlank String,
        gender: @Size(min=1) @NotBlank String,
        phoneNumber: @Size(min=10, max=10) @NotBlank String
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

    fun finish(): Customer {
        modifiedAt = Instant.now()
        modificationZoneId = ZoneId.systemDefault()
        return this
    }

    fun modify(requestDto: CustomerModificationRequestDto): Customer {
        id = UUID.randomUUID()
        firstName = requestDto.firstName
        middleName = requestDto.middleName
        lastName = requestDto.lastName
        birthDate = requestDto.birthDate
        email = requestDto.email
        gender = requestDto.gender
        phoneNumber = requestDto.phoneNumber
        modifiedAt = null
        modificationZoneId = null
        return this
    }

}
