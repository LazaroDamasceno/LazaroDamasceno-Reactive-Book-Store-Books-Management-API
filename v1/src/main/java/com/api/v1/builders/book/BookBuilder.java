package com.api.v1.builders.book;

import com.api.v1.domain.entities.Book;
import com.api.v1.dtos.requests.NewBookRequestDto;

public class BookBuilder {

    private String isbn;
    private String title;
    private String subtitle;
    private String author;
    private String field;
    private int numberOfPages;
    private int version;
    private double price;
    private String publisher;
    private int publishingYear;

    protected BookBuilder() {}

    public static BookBuilder create() {
        return new BookBuilder();
    }

    public BookBuilder fromDto(NewBookRequestDto request) {
        this.isbn = request.isbn();
        this.title = request.title();
        this.subtitle = request.subtitle();
        this.author = request.author();
        this.field = request.field();
        this.numberOfPages = request.numberOfPages();
        this.version = request.version();
        this.price = request.price();
        this.publisher = request.publisher();
        this.publishingYear = request.publishingYear();
        return this;
    }

    public Book build() {
        return new Book(
                isbn,
                title,
                subtitle,
                author,
                field,
                numberOfPages,
                version,
                price,
                publisher,
                publishingYear
        );
    }
    
}
