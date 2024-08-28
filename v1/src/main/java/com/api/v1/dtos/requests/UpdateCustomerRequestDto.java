package com.api.v1.dtos.requests;

import java.time.LocalDate;

public record UpdateCustomerRequestDto(
    String firstName, 
    String middleName, 
    String lastName, 
    LocalDate birthDate, 
    String email,
    String address, 
    String phoneNumber, 
    String gender
) {
     
}
