package com.api.v2.book.services

import com.api.v2.book.annotations.ISBN
import com.api.v2.book.domain.BookRepository
import com.api.v2.book.dtos.BookResponseDto
import com.api.v2.book.utils.BookFinderUtil
import com.api.v2.book.utils.BookResponseMapper
import com.api.v2.exceptions.EmptyEntityException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class BookRetrievalServiceImpl: BookRetrievalService {

    @Autowired
    lateinit var bookRepository: BookRepository

    @Autowired
    lateinit var bookFinderUtil: BookFinderUtil

    override suspend fun findByIsbn(isbn: @ISBN String): BookResponseDto {
        return withContext(Dispatchers.IO) {
            val book = bookFinderUtil.findOne(isbn)
            BookResponseMapper.map(book)
        }
    }

    override suspend fun findAll(): Flow<BookResponseDto> {
        return withContext(Dispatchers.IO) {
            val books = bookRepository.findAll()
            if (books.count() == 0) throw EmptyEntityException()
            books
                .filter { e -> e.archivedAt == null }
                .map { e -> BookResponseMapper.map(e) }
        }
    }

}