package com.api.v2.book

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field
import java.time.Instant
import java.time.ZoneId
import java.util.UUID

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
    var modifiedAt: Instant,
    @Field
    var modificationZoneId: ZoneId
) {
}