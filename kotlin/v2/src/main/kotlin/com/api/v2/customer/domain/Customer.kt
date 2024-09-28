package com.api.v2.customer.domain

import com.api.v2.customer.dtos.CustomerModificationRequestDto
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

@Table("customers")
data class Customer(
    @Id
    var id: UUID?,
    var firstName: String,
    var middleName: String?,
    var lastName: String,
    val ssn: String,
    var birthDate: LocalDate,
    var email: String,
    var gender: String,
    var phoneNumber: String,
    val createdAt: Instant,
    val creationZoneId: ZoneId,
    var modifiedAt: Instant?,
    var modificationZoneId: ZoneId?
) {

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
