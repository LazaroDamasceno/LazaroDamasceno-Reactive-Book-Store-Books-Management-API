package com.api.v2.book.services

import com.api.v2.book.dtos.BookModificationRequestDto
import com.api.v2.book.dtos.BookResponseDto

interface BookModificationService {

    suspend fun modify(isbn: String, requestDto: BookModificationRequestDto): BookResponseDto

}