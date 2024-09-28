package com.api.v2.customer.controller

import com.api.v2.customer.anotations.SSN
import com.api.v2.customer.service.CustomerRegistrationService
import com.api.v2.customer.dtos.CustomerResponseDto
import com.api.v2.customer.dtos.CustomerModificationRequestDto
import com.api.v2.customer.dtos.CustomerRegistrationRequestDto
import com.api.v2.customer.service.CustomerDeletionService
import com.api.v2.customer.service.CustomerModificationService
import com.api.v2.customer.service.CustomerRetrievalService
import jakarta.validation.Valid
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v2/customers")
class CustomerController {

    @Autowired
    private lateinit var customerRegistrationService: CustomerRegistrationService

    @Autowired
    private lateinit var customerModificationService: CustomerModificationService

    @Autowired
    private lateinit var customerRetrievalService: CustomerRetrievalService

    @Autowired
    private lateinit var customerDeletionService: CustomerDeletionService

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun register(@RequestBody requestDto: @Valid CustomerRegistrationRequestDto): CustomerResponseDto {
        return customerRegistrationService.register(requestDto)
    }

    @PutMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    suspend fun modify(
        @PathVariable ssn: @SSN String,
        @RequestBody requestDto: @Valid CustomerModificationRequestDto
    ): CustomerResponseDto {
        return customerModificationService.modify(ssn, requestDto)
    }

    @GetMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun findBySsn(@PathVariable ssn: @SSN String): CustomerResponseDto {
        return customerRetrievalService.findBySsn(ssn)
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun findAll(): Flow<CustomerResponseDto> {
        return customerRetrievalService.findAll()
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    suspend fun deleteAll() {
        return customerDeletionService.deleteAll()
    }

    @DeleteMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    suspend fun deleteBySsn(@PathVariable ssn: @SSN String) {
        return customerDeletionService.deleteBySsn(ssn)
    }

}