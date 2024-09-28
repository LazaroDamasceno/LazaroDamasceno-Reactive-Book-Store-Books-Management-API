package com.api.v2.book.domain

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface BookRepository: CoroutineCrudRepository<Book, String>