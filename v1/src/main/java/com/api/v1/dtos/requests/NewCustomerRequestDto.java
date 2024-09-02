package com.api.v1.dtos.requests;

import java.time.LocalDate;

import com.api.v1.annotations.SSN;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewCustomerRequestDto(
    @NotBlank String firstName, 
    @NotBlank String middleName, 
    @NotBlank String lastName, 
    @SSN String ssn, 
    @NotNull LocalDate birthDate, 
    @NotBlank @Email String email,
    @NotBlank String address, 
    @NotBlank @Size(min=10, max=10) String phoneNumber, 
    @NotBlank @Size(min=1) String gender
) {
    
}
