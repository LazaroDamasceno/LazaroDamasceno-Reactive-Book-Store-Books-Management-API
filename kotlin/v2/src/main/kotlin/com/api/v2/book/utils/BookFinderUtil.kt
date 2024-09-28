package com.api.v2.book.utils

import com.api.v2.book.exceptions.BookNotFoundException
import com.api.v2.book.domain.Book
import com.api.v2.book.domain.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class BookFinderUtil {

    @Autowired
    private lateinit var bookRepository: BookRepository

    suspend fun find(isbn: String): Book {
        return withContext(Dispatchers.IO) {
            val existingBook = bookRepository
                    .findAll()
                    .filter { e -> e.isbn == isbn}
                    .singleOrNull()
            if (existingBook == null) throw BookNotFoundException(isbn)
            existingBook
        }
    }

}