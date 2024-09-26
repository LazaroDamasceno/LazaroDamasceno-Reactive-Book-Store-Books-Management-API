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

    fun finish(): Book {
        modifiedAt = Instant.now()
        modificationZoneId = ZoneId.systemDefault()
        return this
    }

    fun modify(requestDto: BookModificationRequestDto): Book {
        id = UUID.randomUUID()
        title = requestDto.title
        subtitle = requestDto.subtitle
        author = requestDto.author
        field = requestDto.field
        publisher = requestDto.publisher
        numberOfPages = requestDto.numberOfPages
        version = requestDto.version
        modifiedAt = null
        modificationZoneId = null
        return this
    }

    fun fullTitle(): String {
        if (subtitle.isNullOrEmpty()) {
            return title
        }
        return "$title: $subtitle"
    }

}