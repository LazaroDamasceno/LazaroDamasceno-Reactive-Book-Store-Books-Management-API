package com.api.v1.mappers.customer;

import com.api.v1.domain.entities.Customer;
import com.api.v1.dtos.responses.CustomerResponseDto;

public class CustomerResponseMapper {

    public static CustomerResponseDto map(Customer customer) {
        return new CustomerResponseDto(
            customer.getFullName(), 
            customer.getSsn(), 
            customer.getBirthDate(), 
            customer.getEmail(), 
            customer.getAddress(), 
            customer.getPhoneNumber(), 
            customer.getGender()
        );
    }
    
}
