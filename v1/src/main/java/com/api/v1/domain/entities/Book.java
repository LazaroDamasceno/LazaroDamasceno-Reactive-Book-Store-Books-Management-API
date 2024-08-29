package com.api.v1.domain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.ZonedDateTime;
import java.util.UUID;

@Document(collection = "v1_books")
public class Book {

    @Id
    private UUID id = UUID.randomUUID();

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
    private String archivedAt;

    public Book(
            String isbn,
            String title,
            String subtitle,
            String author,
            String field,
            int numberOfPages,
            int version
    ) {
        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        this.field = field;
        this.numberOfPages = numberOfPages;
        this.version = version;
    }

    public void archive() {
        this.archivedAt = ZonedDateTime.now().toString();
    }

    public Book update(
            String title,
            String subtitle,
            String author,
            String field,
            int numberOfPages,
            int version
    ) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        this.field = field;
        this.numberOfPages = numberOfPages;
        this.version = version;
        this.archivedAt = null;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getAuthor() {
        return author;
    }

    public String getField() {
        return field;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getVersion() {
        return version;
    }

    public String getArchivedAt() {
        return archivedAt;
    }

}
