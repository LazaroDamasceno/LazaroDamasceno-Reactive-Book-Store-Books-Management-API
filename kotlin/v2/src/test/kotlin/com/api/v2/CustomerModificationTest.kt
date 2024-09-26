package com.api.v2

import com.api.v2.customer.dtos.CustomerModificationRequestDto
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import java.time.LocalDate

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
private class CustomerModificationTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    val requestDto = CustomerModificationRequestDto(
        "Leonardo",
        "Silva",
        "Santos Jr.",
        LocalDate.parse("1997-12-12"),
        "jr@leosantos.com",
        "cis male",
        "0987654321"
    )

    @Test
    @Order(1)
    fun testSuccessfulModification() {
        webTestClient
            .put()
            .uri("api/v2/customers/123456789")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    fun testUnsuccessfulModification() {
        webTestClient
            .put()
            .uri("api/v2/customers/123456788")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}