package com.api.v2.customer.domain

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.*

interface CustomerRepository: CoroutineCrudRepository<Customer, UUID>