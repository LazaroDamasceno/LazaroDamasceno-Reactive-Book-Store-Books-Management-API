package com.api.v2.book

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.Instant
import java.time.ZoneId
import java.util.UUID

@Document(collection = "v2_books")
data class Book(
    @Id
    var id: UUID,
    @Field
    var title: String,
    @Field
    var subtitle: String?,
    @Field
    val isbn: String,
    @Field
    var author: String,
    @Field
    var field: String,
    @Field
    var publisher: String,
    @Field
    var numberOfPages: Int,
    @Field
    var version: Int,
    @Field
    val createdAt: Instant,
    @Field
    val creationZoneId: ZoneId,
    @Field
    var modifiedAt: Instant?,
    @Field
    var modificationZoneId: ZoneId?
) {

    constructor(
        title: String,
        subtitle: String?,
        isbn: String,
        author: String,
        field: String,
        publisher: String,
        numberOfPages: Int,
        version: Int
    ) : this(
        UUID.randomUUID(),
        title,
        subtitle,
        isbn,
        author,
        field,
        publisher,
        numberOfPages,
        version,
        Instant.now(),
        ZoneId.systemDefault(),
        null,
        null
    )

    fun modify(
        title: String,
        subtitle: String?,
        author: String,
        field: String,
        publisher: String,
        numberOfPages: Int,
        version: Int
    ): Book {
        this.title = title
        this.subtitle = subtitle
        this.author = author
        this.field = field
        this.publisher = publisher
        this.numberOfPages = numberOfPages
        this.version = version
        return this
    }

    fun fullTitle(): String {
        if (subtitle.isNullOrEmpty()) {
            return title
        }
        return "$title: $subtitle"
    }

}