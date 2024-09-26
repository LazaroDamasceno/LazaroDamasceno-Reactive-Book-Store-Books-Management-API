package com.api.v2

class CustomerResponseMapper {

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