package com.api.v1;

import com.api.v1.dtos.requests.NewCustomerRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerRegistrationTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testSuccessfulCustomerRegistration() {

		var newCustomer = new NewCustomerRequestDto(
				"Leo",
				"",
				"Santos",
				"123456789",
				LocalDate.parse("2000-12-12"),
				"leosantos@mail.com",
				"St. Dennis, Paris",
				"1234567890",
				"male"
		);

		webTestClient
				.post()
				.uri("api/v1/customers")
				.bodyValue(newCustomer)
				.exchange()
				.expectStatus().is2xxSuccessful();
	}

	@Test
	void testUnsuccessfulCustomerRegistration() {

		var newCustomer = new NewCustomerRequestDto(
				"Leo",
				"",
				"Santos",
				"123456789",
				LocalDate.parse("2000-12-12"),
				"leosantos@mail.com",
				"St. Dennis, Paris",
				"1234567890",
				"male"
		);

		webTestClient
				.post()
				.uri("api/v1/customers")
				.bodyValue(newCustomer)
				.exchange()
				.expectStatus().is5xxServerError();
	}

}
