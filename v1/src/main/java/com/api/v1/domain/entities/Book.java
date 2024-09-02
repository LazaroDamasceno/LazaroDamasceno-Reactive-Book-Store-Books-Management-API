package com.api.v1.domain.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.ZonedDateTime;

@Document(collection = "v1_books")
public class Book {

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

    public void archive() {
        this.archivedAt = ZonedDateTime.now().toString();
    }

    public String getFullTitle() {
        if (subtitle.isEmpty()) return title;
        return String.format("%s: %s", title, subtitle);
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

    public double getPrice() {
        return price;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

}
