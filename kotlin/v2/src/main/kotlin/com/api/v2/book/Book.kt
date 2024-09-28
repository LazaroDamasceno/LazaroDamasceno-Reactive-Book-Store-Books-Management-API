package com.api.v2.book

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.time.ZoneId
import java.util.UUID

@Table("books")
data class Book(
    @Id
    var id: String,
    var title: @NotBlank String,
    var subtitle: String?,
    val isbn: @ISBN String,
    var author: @NotBlank String,
    var field: @NotBlank String,
    var publisher: @NotBlank String,
    var numberOfPages: @Min(1) Int,
    var version: @Min(1) Int,
    val createdAt: Instant,
    val creationZoneId: ZoneId,
    var modifiedAt: Instant?,
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
        UUID.randomUUID().toString(),
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
        id = UUID.randomUUID().toString()
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