package com.api.v1.exceptions;

public class DuplicatedSsnError extends RuntimeException {

    public DuplicatedSsnError(String ssn) {
        super("SSN %s is already registered.".formatted(ssn));
    }
    
}
