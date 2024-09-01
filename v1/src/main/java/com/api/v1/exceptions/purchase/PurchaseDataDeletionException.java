package com.api.v1.exceptions.purchase;

public class PurchaseDataDeletionException extends RuntimeException {

    public PurchaseDataDeletionException() {
        super("There's no entity 'Purchase' registered.");
    }

}
