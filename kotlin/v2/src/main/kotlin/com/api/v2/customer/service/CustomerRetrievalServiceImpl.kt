package com.api.v2.customer.service

import com.api.v2.customer.anotations.SSN
import com.api.v2.customer.domain.CustomerRepository
import com.api.v2.customer.dtos.CustomerResponseDto
import com.api.v2.customer.utils.CustomerFinderUtil
import com.api.v2.customer.utils.CustomerResponseMapperUtil
import com.api.v2.exceptions.EmptyEntityException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class CustomerRetrievalServiceImpl: CustomerRetrievalService {

    @Autowired
    lateinit var customerFinderUtil: CustomerFinderUtil

    @Autowired
    lateinit var customerRepository: CustomerRepository

    override suspend fun findBySsn(ssn: @SSN String): CustomerResponseDto {
        return withContext(Dispatchers.IO) {
            val customer = customerFinderUtil.findOne(ssn)
            CustomerResponseMapperUtil.map(customer)
        }
    }

    override suspend fun findAll(): Flow<CustomerResponseDto> {
        return withContext(Dispatchers.IO) {
            if (customerRepository.findAll().count() == 0) {
                throw EmptyEntityException()
            }
            customerRepository
                .findAll()
                .filter { e -> e.archivedAt == null }
                .map { e -> CustomerResponseMapperUtil.map(e) }
        }
    }

}