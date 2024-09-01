package com.api.v1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerDeletionTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulAllCustomersDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/customers")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

    }

    @Test
    void testUnsuccessfulAllCustomersDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/customers")
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    void testSuccessfulCustomerDeletionBySsn() {
        String ssn = "123456789";
        webTestClient
                .delete()
                .uri("api/v1/customers/%s".formatted(ssn))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

    }

    @Test
    void testUnsuccessfulCustomerDeletionWithExistingSsn() {
        String ssn = "123456789";
        webTestClient
                .delete()
                .uri("api/v1/customers/%s".formatted(ssn))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    void testUnsuccessfulCustomerDeletionWithNonExistingSsn() {
        String ssn = "123456788";
        webTestClient
                .delete()
                .uri("api/v1/customers/%s".formatted(ssn))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
