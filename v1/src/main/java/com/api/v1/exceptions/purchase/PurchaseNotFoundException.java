package com.api.v1.exceptions.purchase;

public class PurchaseNotFoundException extends RuntimeException {

    public PurchaseNotFoundException() {
        super("Purchase was not found.");
    }

}
