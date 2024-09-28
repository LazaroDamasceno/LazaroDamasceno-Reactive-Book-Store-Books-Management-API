package com.api.v2.customer.domain

import com.api.v2.customer.dtos.CustomerModificationRequestDto
import com.api.v2.customer.dtos.CustomerRegistrationRequestDto
import jakarta.validation.Valid
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

@Table("customers")
class Customer {

    @Id
    var id: UUID? = null
    var firstName: String
    var middleName: String?
    var lastName: String
    val ssn: String
    var birthDate: LocalDate
    var email: String
    var gender: String
    var phoneNumber: String
    val createdAt: Instant = Instant.now()
    val creationZoneId: ZoneId = ZoneId.systemDefault()
    var modifiedAt: Instant? = null
    var modificationZoneId: ZoneId? = null

    constructor(requestDto: CustomerRegistrationRequestDto) {
        this.firstName = requestDto.firstName
        this.middleName = requestDto.middleName
        this.lastName = requestDto.lastName
        this.ssn = requestDto.ssn
        this.birthDate = requestDto.birthDate
        this.email = requestDto.email
        this.gender = requestDto.gender
        this.phoneNumber = requestDto.phoneNumber
    }

    fun fullName(): String {
        if (middleName.isNullOrEmpty()) {
            return "$firstName $lastName"
        }
        return "$firstName $middleName $lastName"
    }

    fun modify(requestDto: CustomerModificationRequestDto) {
        firstName = requestDto.firstName
        middleName = requestDto.middleName
        lastName = requestDto.lastName
        birthDate = requestDto.birthDate
        email = requestDto.email
        gender = requestDto.gender
        phoneNumber = requestDto.phoneNumber
        modifiedAt = Instant.now()
        modificationZoneId = ZoneId.systemDefault()
    }

}
