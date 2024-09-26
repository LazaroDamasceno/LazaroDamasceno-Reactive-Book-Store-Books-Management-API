package com.api.v2.customer.utils

import com.api.v2.customer.domain.Customer
import com.api.v2.customer.domain.CustomerRepository
import com.api.v2.customer.exceptions.CustomerNotFoundException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired

class CustomerFInderUtil {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    suspend fun find(ssn: String): Customer {
        return withContext(Dispatchers.IO) {
            val existingCustomer = customerRepository
                .findAll()
                .filter { e -> e.ssn == ssn }
                .singleOrNull()
            if (existingCustomer == null) {
                    throw CustomerNotFoundException()
                }
            existingCustomer
        }
    }

}