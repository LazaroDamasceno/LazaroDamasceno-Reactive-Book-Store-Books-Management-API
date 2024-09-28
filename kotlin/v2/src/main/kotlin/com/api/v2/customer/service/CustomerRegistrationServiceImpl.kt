package com.api.v2.customer.service

import com.api.v2.customer.dtos.CustomerResponseDto
import com.api.v2.customer.utils.CustomerResponseMapperUtil
import com.api.v2.customer.exceptions.DuplicatedSsnException
import com.api.v2.customer.domain.Customer
import com.api.v2.customer.domain.CustomerRepository
import com.api.v2.customer.dtos.CustomerModificationRequestDto
import com.api.v2.customer.dtos.CustomerRegistrationRequestDto
import com.api.v2.customer.exceptions.DuplicatedEmailException
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class CustomerRegistrationServiceImpl: CustomerRegistrationService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    override suspend fun register(requestDto: @Valid CustomerRegistrationRequestDto): CustomerResponseDto {
        return withContext(Dispatchers.IO) {
            if (customerRepository.findAll().filter { e -> e.ssn == requestDto.ssn }.count() != 0) {
                throw DuplicatedSsnException(requestDto.ssn)
            }
            if (customerRepository
                .findAll()
                .filter { e ->
                    e.email == requestDto.email
                            && e.archivedAt == null
                }.count() != 0) {
                    throw DuplicatedEmailException(requestDto.email)
            }
            val customer = Customer(requestDto)
            val savedCustomer = customerRepository.save(customer)
            CustomerResponseMapperUtil.map(savedCustomer)
        }
    }

    override suspend fun register(
        existingCustomer: @NotNull Customer,
        requestDto: @Valid CustomerModificationRequestDto
    ): CustomerResponseDto {
        return withContext(Dispatchers.IO) {
            val modifiedCustomer = Customer(
                existingCustomer.ssn,
                requestDto,
                existingCustomer.createdAt,
                existingCustomer.creationZoneId
            )
            val savedCustomer = customerRepository.save(modifiedCustomer)
            CustomerResponseMapperUtil.map(savedCustomer)
        }
    }

}