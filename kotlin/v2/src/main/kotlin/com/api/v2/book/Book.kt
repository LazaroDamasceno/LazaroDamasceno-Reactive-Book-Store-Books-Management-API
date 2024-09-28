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
    var subtitle: String? = null
    lateinit var isbn: String
    var author: String
    var field: String
    var publisher: String
    var numberOfPages: Int
    var version: Int
    var publishingYear: Int
    val createdAt: Instant = Instant.now()
    val creationZoneId: ZoneId = ZoneId.systemDefault()
    var archivedAt: Instant? = null
    var archivingZoneId: ZoneId? = null

    constructor(
        isbn: String,
        title: String,
        subtitle: String?,
        field: String,
        publisher: String,
        publishingYear: Int,
        version: Int,
        numberOfPages: Int,
        author: String
    ) {
        this.title = title
        this.subtitle = subtitle
        this.field = field
        this.isbn = isbn
        this.publisher = publisher
        this.publishingYear = publishingYear
        this.version = version
        this.numberOfPages = numberOfPages
        this.author = author
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