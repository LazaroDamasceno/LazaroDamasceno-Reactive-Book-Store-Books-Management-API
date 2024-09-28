package com.api.v2.customer.domain

import com.api.v2.customer.dtos.CustomerModificationRequestDto
import com.api.v2.customer.dtos.CustomerRegistrationRequestDto
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
    lateinit var firstName: String
    var middleName: String? = null
    lateinit var lastName: String
    lateinit var ssn: String
    lateinit var birthDate: LocalDate
    lateinit var email: String
    lateinit var gender: String
    lateinit var phoneNumber: String
    var createdAt: Instant = Instant.now()
    var creationZoneId: ZoneId = ZoneId.systemDefault()
    var archivedAt: Instant? = null
    var archivingZoneId: ZoneId? = null

    constructor() {}

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

    constructor(
        ssn: String,
        requestDto: CustomerModificationRequestDto,
        createdAt: Instant,
        creationZoneId: ZoneId
    ) {
        this.firstName = requestDto.firstName
        this.middleName = requestDto.middleName
        this.lastName = requestDto.lastName
        this.ssn = ssn
        this.birthDate = requestDto.birthDate
        this.email = requestDto.email
        this.gender = requestDto.gender
        this.phoneNumber = requestDto.phoneNumber
        this.createdAt = createdAt
        this.creationZoneId = creationZoneId
    }

    fun fullName(): String {
        if (middleName.isNullOrEmpty()) {
            return "$firstName $lastName"
        }
        return "$firstName $middleName $lastName"
    }

    fun archive() {
        archivedAt = Instant.now()
        archivingZoneId = ZoneId.systemDefault()
    }

}
