package com.api.v2.customer.service

import com.api.v2.customer.dtos.CustomerResponseDto
import com.api.v2.customer.utils.CustomerResponseMapperUtil
import com.api.v2.customer.exceptions.DuplicatedSsnException
import com.api.v2.customer.domain.Customer
import com.api.v2.customer.domain.CustomerRepository
import com.api.v2.customer.dtos.CustomerRegistrationRequestDto
import jakarta.validation.Valid import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.ZoneId

@Service
private class CustomerRegistrationServiceImpl: CustomerRegistrationService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    override suspend fun register(requestDto: @Valid CustomerRegistrationRequestDto): CustomerResponseDto {
        return withContext(Dispatchers.IO) {
            if (customerRepository.findAll().filter { e -> e.ssn == requestDto.ssn }.count() != 0) {
                throw DuplicatedSsnException(requestDto.ssn)
            }
            val customer = Customer(
                requestDto.firstName,
                requestDto.middleName,
                requestDto.lastName,
                requestDto.ssn,
                requestDto.birthDate,
                requestDto.email,
                requestDto.gender,
                requestDto.phoneNumber,
                Instant.now(),
                ZoneId.systemDefault()
            )
            val savedCustomer = customerRepository.save(customer)
            CustomerResponseMapperUtil.map(savedCustomer)
        }
    }

}