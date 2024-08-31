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
    private UUID id;

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
        this.id = UUID.randomUUID();
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

    public String getFullName() {
        if (middleName.isEmpty()) return String.format("%s %s", firstName, lastName);
        return String.format("%s %s %s", firstName, middleName, lastName);
    }

    public void archive() {
        this.archivedAt = ZonedDateTime.now().toString();
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
