package com.api.v1.exceptions.purchase;

public class PurchaseWasNotFoundException extends RuntimeException {

    public PurchaseWasNotFoundException() {
        super("Purchase was not found.");
    }

}
