package com.api.v1.domain.entities;

import com.api.v1.dtos.requests.BookRegistrationRequestDto;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.ZonedDateTime;

@Document(collection = "v1_books")
@Getter
public class Book {

    @Id
    private ObjectId id = new ObjectId();

    @Field
    private String createdAt = ZonedDateTime.now().toString();

    @Field
    private String isbn;

    @Field
    private String title;

    @Field
    private String subtitle;

    @Field
    private String author;

    @Field
    private String field;

    @Field
    private int numberOfPages;

    @Field
    private int version;

    @Field
    private double price;

    @Field
    private String publisher;

    @Field
    private int publishingYear;

    @Field
    private String archivedAt;

    public Book(
            String isbn,
            String title,
            String subtitle,
            String author,
            String field,
            int numberOfPages,
            int version,
            double price,
            String publisher,
            int publishingYear
    ) {
        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        this.field = field;
        this.numberOfPages = numberOfPages;
        this.version = version;
        this.price = price;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
    }

    public Book update(BookRegistrationRequestDto request) {
        this.id = new ObjectId();
        this.title = request.title();
        this.subtitle = request.subtitle();
        this.author = request.author();
        this.field = request.field();
        this.numberOfPages = request.numberOfPages();
        this.version = request.version();
        this.price = request.price();
        this.publisher = request.publisher();
        this.publishingYear = request.publishingYear();
        this.archivedAt = null;
        return this;
    }

    public void inactive() {
        this.archivedAt = ZonedDateTime.now().toString();
    }

    public String getFullTitle() {
        if (subtitle.isEmpty()) return title;
        return String.format("%s: %s", title, subtitle);
    }

}
