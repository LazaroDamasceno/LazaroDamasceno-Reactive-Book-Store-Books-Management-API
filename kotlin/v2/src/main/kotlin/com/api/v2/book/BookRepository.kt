package com.api.v2.book

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface BookRepository: CoroutineCrudRepository<Book, UUID>