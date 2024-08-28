package com.api.v1.domain.entities;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "v1_customers")
public class Customer {

    @Id
    private final UUID id = UUID.randomUUID();

    @Field
    private final String createdAt = ZonedDateTime.now().toString();

    @Field
    private String firstName;

    @Field
    private String middleName;

    @Field
    private String lastName;

    @Field
    private final String ssn;

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
    private String archivedAt;

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

    public String getFullName() {
        if (middleName.isEmpty()) return String.format("%s %s", firstName, lastName);
        return String.format("%s %s %s", firstName, middleName, lastName);
    }

    public void archived() {
        this.archivedAt = ZonedDateTime.now().toString();
    }

    public Customer update(
        String firstName, 
        String middleName, 
        String lastName, 
        LocalDate birthDate, 
        String email,
        String address, 
        String phoneNumber, 
        String gender
    ) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getArchivedAt() {
        return archivedAt;
    }
    
}
