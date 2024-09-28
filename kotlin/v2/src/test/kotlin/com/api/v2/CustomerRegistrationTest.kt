package com.api.v2

import com.api.v2.customer.dtos.CustomerRegistrationRequestDto
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
private class CustomerRegistrationTest {

	@Autowired
	lateinit var webTestClient: WebTestClient

	val customer = CustomerRegistrationRequestDto(
		"Leo",
		"",
		"Santos",
		"123456789",
		LocalDate.parse("2000-12-12"),
		"leosantos@mail.com",
		"male",
		"1234567890"
	)

	@Test
	@Order(1)
	fun testSuccessfulRegistration() {
		webTestClient
			.post()
			.uri("api/v2/customers")
			.bodyValue(customer)
			.exchange()
			.expectStatus()
			.is2xxSuccessful()
	}

	@Test
	fun testUnsuccessfulRegistration() {
		webTestClient
			.post()
			.uri("api/v2/customers")
			.bodyValue(customer)
			.exchange()
			.expectStatus()
			.is5xxServerError()
	}

}
