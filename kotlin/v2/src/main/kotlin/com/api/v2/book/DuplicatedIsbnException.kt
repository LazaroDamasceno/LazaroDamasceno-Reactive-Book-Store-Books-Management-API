package com.api.v2.book

class DuplicatedIsbnException(isbn: String)
    : RuntimeException("The ISBN $isbn is already registered.")