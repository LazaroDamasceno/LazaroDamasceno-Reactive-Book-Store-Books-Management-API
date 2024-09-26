package com.api.v2.book

data class BookModificationRequestDto(
    val title: String,
    val subtitle: String?,
    val author: String,
    val field: String,
    val publisher: String,
    val numberOfPages: Int,
    val version: Int
)
