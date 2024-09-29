package com.api.v2.book.services

import com.api.v2.book.dtos.BookResponseDto
import kotlinx.coroutines.flow.Flow

interface BookRetrievalService {

    suspend fun findByIsbn(isbn: String): BookResponseDto
    suspend fun findAll(): Flow<BookResponseDto>

}