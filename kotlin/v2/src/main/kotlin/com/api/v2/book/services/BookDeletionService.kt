package com.api.v2.book.services

interface BookDeletionService {

    suspend fun deleteByIsbn(isbn: String)
    suspend fun deleteAll()

}