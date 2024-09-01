package com.api.v1.exceptions.customer;

public class CustomerDataDeletionException extends RuntimeException {

    public CustomerDataDeletionException() {
        super("There no entity 'Customer' registered.");
    }

}
