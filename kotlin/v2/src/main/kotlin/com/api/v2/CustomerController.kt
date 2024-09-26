package com.api.v2

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v2/customers")
class CustomerController {

    @Autowired
    private lateinit var customerRegistrationService: CustomerRegistrationService

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun register(@RequestBody customer: @Valid Customer): CustomerResponseDto {
        return customerRegistrationService.register(customer)
    }

}