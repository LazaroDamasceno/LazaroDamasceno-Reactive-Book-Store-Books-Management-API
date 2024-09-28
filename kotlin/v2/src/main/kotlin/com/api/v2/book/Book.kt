package com.api.v2.book

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.time.ZoneId
import java.util.UUID

@Table("books")
class Book {

    @Id
    var id: UUID? = null
    var title: String
    var subtitle: String?
    val isbn: String
    var author: String
    var field: String
    var publisher: String
    var numberOfPages: Int
    var version: Int
    var publishingYear: Int
    val createdAt: Instant = Instant.now()
    val creationZoneId: ZoneId = ZoneId.systemDefault()
    var modifiedAt: Instant? = null
    var modificationZoneId: ZoneId? = null

    constructor(requestDto: BookRegistrationRequestDto) {
        this.title = requestDto.title
        this.subtitle = requestDto.subtitle
        this.isbn = requestDto.isbn
        this.author = requestDto.author
        this.field = requestDto.field
        this.publisher = requestDto.publisher
        this.numberOfPages = requestDto.numberOfPages
        this.version = requestDto.version
        this.publishingYear = requestDto.publishingYear
    }

    fun modify(requestDto: BookModificationRequestDto) {
        title = requestDto.title
        subtitle = requestDto.subtitle
        author = requestDto.author
        field = requestDto.field
        publisher = requestDto.publisher
        numberOfPages = requestDto.numberOfPages
        version = requestDto.version
        modifiedAt = Instant.now()
        modificationZoneId = ZoneId.systemDefault()
    }

    fun fullTitle(): String {
        if (subtitle.isNullOrEmpty()) {
            return title
        }
        return "$title: $subtitle"
    }

}