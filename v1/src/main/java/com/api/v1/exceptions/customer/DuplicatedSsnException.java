package com.api.v1.exceptions.customer;

public class DuplicatedSsnException extends RuntimeException {

    public DuplicatedSsnException(String ssn) {
        super("SSN %s is already registered.".formatted(ssn));
    }
    
}
