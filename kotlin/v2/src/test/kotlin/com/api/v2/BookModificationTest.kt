package com.api.v2

import com.api.v2.book.dtos.BookModificationRequestDto
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
private class BookModificationTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    val requestDto = BookModificationRequestDto(
        "Harry Porter",
        "And the Philosopher's Stone",
        "J.K. Rowling",
        "juvenile fantasy",
        "Bloomsbury",
        336,
        1,
        1997,
        130.13
    )

    @Test
    @Order(1)
    fun testSuccessfulModification() {
        webTestClient
            .put()
            .uri("api/v2/books/1234567890123")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    fun testUnsuccessfulModification() {
        webTestClient
            .put()
            .uri("api/v2/books/1234567890122")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}