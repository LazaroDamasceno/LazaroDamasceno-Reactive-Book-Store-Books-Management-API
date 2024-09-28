package com.api.v2.customer.exceptions

class DuplicatedEmailException(email: String)
    : RuntimeException("The email $email is already registered.")