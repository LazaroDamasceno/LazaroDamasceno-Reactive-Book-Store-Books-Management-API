package com.api.v1.domain.entities;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import com.api.v1.dtos.requests.CustomerRegistrationRequestDto;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "v1_customers")
@Getter
public class Customer {

    @Field
    private String createdAt;

    @Field
    private String firstName;

    @Field
    private String middleName;

    @Field
    private String lastName;

    @Field
    private String ssn;

    @Field
    private LocalDate birthDate;

    @Field
    private String email;

    @Field
    private String address;

    @Field
    private String phoneNumber;

    @Field
    private String gender;

    @Field
    private String updatedAt;

    public Customer(
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
        this.createdAt = ZonedDateTime.now().toString();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public void update(CustomerRegistrationRequestDto request) {
        this.firstName = request.firstName();
        this.middleName = request.middleName();
        this.lastName = request.lastName();
        this.ssn = request.ssn();
        this.birthDate = request.birthDate();
        this.email = request.email();
        this.address = request.address();
        this.phoneNumber = request.phoneNumber();
        this.gender = request.gender();
        this.updatedAt = ZonedDateTime.now().toString();
    }

    public String getFullName() {
        if (middleName.isEmpty()) return String.format("%s %s", firstName, lastName);
        return String.format("%s %s %s", firstName, middleName, lastName);
    }

}
