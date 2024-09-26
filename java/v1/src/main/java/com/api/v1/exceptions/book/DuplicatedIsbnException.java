package com.api.v1.exceptions.book;

public class DuplicatedIsbnException extends RuntimeException {

    public DuplicatedIsbnException(String isbn) {
        super("The ISBN %s is already registered.");
    }

}