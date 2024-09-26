package com.api.v2.customer.utils

import com.api.v2.customer.domain.Customer
import com.api.v2.customer.dtos.CustomerResponseDto

class CustomerResponseMapperUtil {

    companion object {
        fun map(customer: Customer): CustomerResponseDto {
            return CustomerResponseDto(
                customer.fullName(),
                customer.ssn,
                customer.birthDate,
                customer.email,
                customer.gender,
                customer.phoneNumber
            )
        }
    }

}