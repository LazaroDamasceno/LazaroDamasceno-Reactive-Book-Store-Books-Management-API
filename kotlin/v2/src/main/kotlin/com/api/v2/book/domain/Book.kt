package com.api.v2.book.domain

import com.api.v2.book.dtos.BookModificationRequestDto
import com.api.v2.book.dtos.BookRegistrationRequestDto
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.time.ZoneId
import java.util.UUID

@Table("books")
class Book {

    @Id
    var id: UUID? = null
    lateinit var title: String
    var subtitle: String? = null
    lateinit var isbn: String
    lateinit var author: String
    lateinit var field: String
    lateinit var publisher: String
    var numberOfPages: Int = 1
    var version: Int = 1
    var publishingYear: Int = 0
    var createdAt: Instant = Instant.now()
    var creationZoneId: ZoneId = ZoneId.systemDefault()
    var archivedAt: Instant? = null
    var archivingZoneId: ZoneId? = null

    constructor()

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

    constructor(
        isbn: String,
        requestDto: BookModificationRequestDto,
        createdAt: Instant,
        creationZoneId: ZoneId
    ) {
        this.isbn = isbn
        this.title = requestDto.title
        this.subtitle = requestDto.subtitle
        this.author = requestDto.author
        this.field = requestDto.field
        this.publisher = requestDto.publisher
        this.numberOfPages = requestDto.numberOfPages
        this.version = requestDto.version
        this.publishingYear = requestDto.publishingYear
        this.createdAt = createdAt
        this.creationZoneId = creationZoneId
    }

    fun fullTitle(): String {
        if (subtitle.isNullOrEmpty()) {
            return title
        }
        return "$title: $subtitle"
    }

    fun archive() {
        archivedAt = Instant.now()
        archivingZoneId = ZoneId.systemDefault()
    }

}