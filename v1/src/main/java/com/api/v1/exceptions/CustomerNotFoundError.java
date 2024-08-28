package com.api.v1.exceptions;

public class CustomerNotFoundError extends RuntimeException {

    public CustomerNotFoundError(String ssn) {
        super("Customer whose SSN is %s was not found.".formatted(ssn));
    }
    
}
