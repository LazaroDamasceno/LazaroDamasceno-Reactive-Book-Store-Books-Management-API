package com.api.v1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookDeletionTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulAllCustomersDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/books")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulAllCustomersDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/books")
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    void  testSuccessfulCustomerDeletionByIsbn() {
        webTestClient
                .delete()
                .uri("api/v1/books/%s".formatted("123456789012"))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void  testUnsuccessfulCustomerDeletionByIsbn() {
        webTestClient
                .delete()
                .uri("api/v1/books/%s".formatted("123456789012"))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
