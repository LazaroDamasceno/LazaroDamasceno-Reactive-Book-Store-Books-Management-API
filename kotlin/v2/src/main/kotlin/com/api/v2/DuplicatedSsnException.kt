package com.api.v2

class DuplicatedSsnException(ssn: String): RuntimeException("The SSN $ssn is already registered.")