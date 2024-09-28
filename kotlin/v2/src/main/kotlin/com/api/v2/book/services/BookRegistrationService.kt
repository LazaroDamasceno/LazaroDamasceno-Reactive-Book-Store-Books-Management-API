package com.api.v2.book.services

import com.api.v2.book.domain.Book
import com.api.v2.book.dtos.BookModificationRequestDto
import com.api.v2.book.dtos.BookRegistrationRequestDto
import com.api.v2.book.dtos.BookResponseDto
import java.time.Instant
import java.time.ZoneId

interface BookRegistrationService {

    suspend fun register(requestDto: BookRegistrationRequestDto): BookResponseDto
    suspend fun register(book: Book, requestDto: BookModificationRequestDto): BookResponseDto

}