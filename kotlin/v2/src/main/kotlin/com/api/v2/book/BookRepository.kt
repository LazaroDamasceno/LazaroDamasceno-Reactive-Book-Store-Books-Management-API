package com.api.v2.book

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface BookRepository: CoroutineCrudRepository<Book, String>