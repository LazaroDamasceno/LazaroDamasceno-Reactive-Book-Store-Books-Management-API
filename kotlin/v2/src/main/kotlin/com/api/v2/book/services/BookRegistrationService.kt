package com.api.v2.book.services

import com.api.v2.book.dtos.BookRegistrationRequestDto
import com.api.v2.book.dtos.BookResponseDto

interface BookRegistrationService {

    suspend fun register(requestDto: BookRegistrationRequestDto): BookResponseDto

}