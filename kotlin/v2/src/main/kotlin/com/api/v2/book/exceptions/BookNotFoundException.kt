package com.api.v2.book.exceptions

class BookNotFoundException(isbn: String)
    : RuntimeException("Book which ISBN is $isbn was not found.")