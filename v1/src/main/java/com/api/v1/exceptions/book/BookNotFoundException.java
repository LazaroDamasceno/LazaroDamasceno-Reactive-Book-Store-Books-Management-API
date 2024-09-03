package com.api.v1.exceptions.book;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String isbn) {
        super("The ISBN %s was not found.".formatted(isbn));
    }

}
