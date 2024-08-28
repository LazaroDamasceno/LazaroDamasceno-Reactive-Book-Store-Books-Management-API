package com.api.v1.dtos.requests;

import java.time.LocalDate;

public record NewCustomerRequestDto(
    String firstName, 
    String middleName, 
    String lastName, 
    String ssn, 
    LocalDate birthDate, 
    String email,
    String address, 
    String phoneNumber, 
    String gender
) {
    
}
