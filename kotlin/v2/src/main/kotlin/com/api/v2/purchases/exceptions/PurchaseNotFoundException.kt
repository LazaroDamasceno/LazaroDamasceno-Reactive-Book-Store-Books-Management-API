package com.api.v2.purchases.exceptions

class PurchaseNotFoundException(orderNumber: String)
    : RuntimeException("Purchase which order number is $orderNumber was not found.")