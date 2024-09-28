package com.api.v2.book

class BookNotFoundException(isbn: String)
    : RuntimeException("Book which ISBN is $isbn was not found.")