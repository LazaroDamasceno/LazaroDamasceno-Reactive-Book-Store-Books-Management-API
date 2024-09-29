package com.api.v2

import com.api.v2.book.dtos.BookRegistrationRequestDto
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
private class BookRegistrationTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    val requestDto = BookRegistrationRequestDto(
        "Harry Porter",
        "The First Book",
        "1234567890123",
        "J.K. Rowling",
        "juvenile fantasy",
        "HP Collins",
        300,
        1,
        1997,
        100.0
    )

    @Test
    @Order(1)
    fun testSuccessfulRegistration() {
        webTestClient
            .post()
            .uri("api/v2/books")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    fun testUnsuccessfulRegistration() {
        webTestClient
            .post()
            .uri("api/v2/books")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}