package com.api.v1.builders;

import java.time.LocalDate;

import com.api.v1.domain.entities.Customer;
import com.api.v1.dtos.requests.NewCustomerRequestDto;

public class CustomerBuilder {

    private String firstName;
    private String middleName; 
    private String lastName;
    private String ssn;
    private LocalDate birthDate;
    private String email;
    private String address;
    private String phoneNumber;
    private String gender;

    public static CustomerBuilder create() {
        return new CustomerBuilder();
    }

    public CustomerBuilder fromDto(NewCustomerRequestDto request) {
        this.firstName = request.firstName();
        this.middleName = request.middleName();
        this.lastName = request.lastName();
        this.ssn = request.ssn();
        this.birthDate = request.birthDate();
        this.email = request.email();
        this.address = request.address();
        this.phoneNumber = request.phoneNumber();
        this.gender = request.gender();
        return this;
    }

    public Customer build() {
        return new Customer(
            firstName, 
            middleName, 
            lastName, 
            ssn, 
            birthDate, 
            email, 
            address, 
            phoneNumber, 
            gender
        );
    };
    
}
