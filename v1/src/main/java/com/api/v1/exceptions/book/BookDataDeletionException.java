package com.api.v1.exceptions.book;

public class BookDataDeletionException extends RuntimeException {

    public BookDataDeletionException() {
        super("There's not entity 'Book' registered.");
    }

}
