package com.api.v2.customer.service

import com.api.v2.customer.anotations.SSN
import com.api.v2.customer.domain.CustomerRepository
import com.api.v2.customer.dtos.CustomerModificationRequestDto
import com.api.v2.customer.dtos.CustomerResponseDto
import com.api.v2.customer.utils.CustomerFinderUtil
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class CustomerModificationServiceImpl: CustomerModificationService {

    @Autowired
    lateinit var customerFinderUtil: CustomerFinderUtil

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var customerRegistrationService: CustomerRegistrationService

    override suspend fun modify(
        ssn: @SSN String,
        requestDto: @Valid CustomerModificationRequestDto
    ): CustomerResponseDto {
        return withContext(Dispatchers.IO) {
            val customer = customerFinderUtil.find(ssn)
            customer.archive()
            val archivedCustomer = customerRepository.save(customer)
            customerRegistrationService.register(archivedCustomer, requestDto)
        }
    }

}