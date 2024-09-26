package com.api.v2.customer.service

import com.api.v2.customer.dtos.CustomerResponseDto
import com.api.v2.customer.utils.CustomerResponseMapperUtil
import com.api.v2.customer.exceptions.DuplicatedSsnException
import com.api.v2.customer.domain.Customer
import com.api.v2.customer.domain.CustomerRepository
import jakarta.validation.Valid
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

    override suspend fun register(customer: @Valid Customer): CustomerResponseDto {

        suspend fun isSsnDuplicated() {
            if (customerRepository
                    .findAll()
                    .filter { e -> e.ssn == customer.ssn }
                    .count() != 0) {
                throw DuplicatedSsnException(customer.ssn)
            }
        }

        return withContext(Dispatchers.IO) {
            isSsnDuplicated()
            val savedCustomer = customerRepository.save(customer)
            CustomerResponseMapperUtil.map(savedCustomer)
        }

    }


}