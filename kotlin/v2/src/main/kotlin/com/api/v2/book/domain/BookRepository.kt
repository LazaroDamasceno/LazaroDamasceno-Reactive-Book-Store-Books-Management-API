package com.api.v2.book.domain

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface BookRepository: CoroutineCrudRepository<Book, String>