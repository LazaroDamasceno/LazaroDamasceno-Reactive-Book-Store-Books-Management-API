package com.api.v2.book.services

import com.api.v2.book.annotations.ISBN
import com.api.v2.book.domain.BookRepository
import com.api.v2.book.dtos.BookModificationRequestDto
import com.api.v2.book.dtos.BookResponseDto
import com.api.v2.book.utils.BookFinderUtil
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class BookModificationServiceImpl: BookModificationService {

    @Autowired
    lateinit var bookFinderUtil: BookFinderUtil

    @Autowired
    lateinit var bookRepository: BookRepository

    @Autowired
    lateinit var bookRegistrationService: BookRegistrationService

    override suspend fun modify(isbn: @ISBN String, requestDto: @Valid BookModificationRequestDto): BookResponseDto {
        return withContext(Dispatchers.IO) {
            val book = bookFinderUtil.find(isbn)
            book.archive()
            val savedArchivedBook = bookRepository.save(book)
            bookRegistrationService.register(savedArchivedBook, requestDto)
        }
    }

}