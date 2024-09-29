package com.api.v2.book.controllers

import com.api.v2.book.annotations.ISBN
import com.api.v2.book.dtos.BookModificationRequestDto
import com.api.v2.book.dtos.BookRegistrationRequestDto
import com.api.v2.book.dtos.BookResponseDto
import com.api.v2.book.services.BookModificationService
import com.api.v2.book.services.BookRegistrationService
import com.api.v2.book.services.BookRetrievalService
import jakarta.validation.Valid
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v2/books")
class BookController: BookRetrievalService {

    @Autowired
    private lateinit var bookRegistrationService: BookRegistrationService

    @Autowired
    private lateinit var bookModificationService: BookModificationService

    @Autowired
    private lateinit var bookRetrievalService: BookRetrievalService

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun register(@RequestBody requestDto: @Valid BookRegistrationRequestDto): BookResponseDto {
        return bookRegistrationService.register(requestDto)
    }

    @PutMapping("{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun modify(
        @PathVariable isbn: @ISBN String,
        @RequestBody requestDto: @Valid BookModificationRequestDto
    ): BookResponseDto {
        return bookModificationService.modify(isbn, requestDto)
    }

    @GetMapping("{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    override suspend fun findByIsbn(@PathVariable isbn: @ISBN String): BookResponseDto {
        return bookRetrievalService.findByIsbn(isbn)
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    override suspend fun findAll(): Flow<BookResponseDto> {
        return bookRetrievalService.findAll()
    }

}