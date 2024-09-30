package com.api.v2

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PurchaseTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    @Order(1)
    fun testSuccessfulPurchase() {
        webTestClient
            .post()
            .uri("api/v2/purchases/123456789/1234567890123")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    fun testUnsuccessfulPurchase1() {
        webTestClient
            .post()
            .uri("api/v2/purchases/123456788/1234567890123")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

    @Test
    fun testUnsuccessfulPurchase2() {
        webTestClient
            .post()
            .uri("api/v2/purchases/123456789/1234567890122")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}