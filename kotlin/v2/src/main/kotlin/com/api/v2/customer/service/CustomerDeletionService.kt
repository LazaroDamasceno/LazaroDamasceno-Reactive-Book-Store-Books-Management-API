package com.api.v2.customer.service

interface CustomerDeletionService {

    suspend fun deleteAll()
    suspend fun deleteBySsn(ssn: String)

}