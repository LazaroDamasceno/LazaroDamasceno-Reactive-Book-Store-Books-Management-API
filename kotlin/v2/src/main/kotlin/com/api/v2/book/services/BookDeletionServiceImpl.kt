package com.api.v2.book.services

import com.api.v2.book.domain.BookRepository
import com.api.v2.book.utils.BookFinderUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class BookDeletionServiceImpl: BookDeletionService {

    @Autowired
    lateinit var bookFinderUtil: BookFinderUtil

    @Autowired
    lateinit var bookRepository: BookRepository

    override suspend fun deleteByIsbn(isbn: String) {
        return withContext(Dispatchers.IO) {
            val books = bookFinderUtil.findMany(isbn)
            bookRepository.deleteAll(books)
        }
    }

    override suspend fun deleteAll() {
        return withContext(Dispatchers.IO) {
            bookRepository.deleteAll()
        }
    }

}