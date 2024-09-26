package com.api.v2.customer.service

import com.api.v2.customer.anotations.SSN
import com.api.v2.customer.domain.CustomerRepository
import com.api.v2.customer.dtos.CustomerModificationRequestDto
import com.api.v2.customer.utils.CustomerFInderUtil
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class CustomerModificationServiceImpl: CustomerModificationService {

    @Autowired
    lateinit var customerFInderUtil: CustomerFInderUtil

    @Autowired
    lateinit var customerRepository: CustomerRepository

    override suspend fun modify(ssn: @SSN String, requestDto: @Valid CustomerModificationRequestDto) {
        return withContext(Dispatchers.IO) {
            val customer = customerFInderUtil.find(ssn)
            val finishedCustomer = customer.finish()
            val savedFinishCustomer = customerRepository.save(finishedCustomer)
            val modifiedCustomer = savedFinishCustomer.modify(requestDto)
            customerRepository.save(modifiedCustomer)
        }
    }

}