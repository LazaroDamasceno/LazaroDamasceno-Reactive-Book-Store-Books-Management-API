package com.api.v2.book.services

import com.api.v2.book.domain.Book
import com.api.v2.book.domain.BookRepository
import com.api.v2.book.dtos.BookModificationRequestDto
import com.api.v2.book.dtos.BookRegistrationRequestDto
import com.api.v2.book.dtos.BookResponseDto
import com.api.v2.book.exceptions.DuplicatedIsbnException
import com.api.v2.book.utils.BookResponseMapper
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class BookRegistrationServiceImpl: BookRegistrationService {

    @Autowired
    lateinit var bookRepository: BookRepository

    override suspend fun register(requestDto: @Valid BookRegistrationRequestDto): BookResponseDto {
        return withContext(Dispatchers.IO) {
            if (bookRepository.findAll().filter { e -> e.isbn == requestDto.isbn }.count() != 0) {
                throw DuplicatedIsbnException(requestDto.isbn)
            }
            val book = Book(requestDto)
            val savedBook = bookRepository.save(book)
            BookResponseMapper.map(savedBook)
        }
    }

    override suspend fun register(book: @NotNull Book, requestDto: @Valid BookModificationRequestDto): BookResponseDto {
        return withContext(Dispatchers.IO) {
            val modifiedBook = Book(
                book.isbn,
                requestDto,
                book.createdAt,
                book.creationZoneId
            )
            val savedBook = bookRepository.save(modifiedBook)
            BookResponseMapper.map(savedBook)
        }
    }

}