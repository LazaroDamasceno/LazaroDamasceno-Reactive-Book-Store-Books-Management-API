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

    @Test
    void  testSuccessfulCustomerDeletionByAuthor() {
        webTestClient
                .delete()
                .uri("api/v1/books/%s".formatted("J.K. Rowling"))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void  testUnsuccessfulCustomerDeletionByAuthor() {
        webTestClient
                .delete()
                .uri("api/v1/books/%s".formatted("J.K. Rowling"))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    void  testSuccessfulCustomerDeletionByField() {
        webTestClient
                .delete()
                .uri("api/v1/books/%s".formatted("juvenile fantasy"))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void  testUnsuccessfulCustomerDeletionByField() {
        webTestClient
                .delete()
                .uri("api/v1/books/%s".formatted("juvenile fantasy"))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    void  testSuccessfulCustomerDeletionByYear() {
        webTestClient
                .delete()
                .uri("api/v1/books/%s".formatted(1997))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void  testUnsuccessfulCustomerDeletionByYear() {
        webTestClient
                .delete()
                .uri("api/v1/books/%s".formatted(1997))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    void  testSuccessfulCustomerDeletionByVersion() {
        webTestClient
                .delete()
                .uri("api/v1/books/%s".formatted(1))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void  testUnsuccessfulCustomerDeletionByVersion() {
        webTestClient
                .delete()
                .uri("api/v1/books/%s".formatted(1))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    void  testSuccessfulCustomerDeletionByPublisher() {
        webTestClient
                .delete()
                .uri("api/v1/books/%s".formatted("Penguin Inc."))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void  testUnsuccessfulCustomerDeletionByPublisher() {
        webTestClient
                .delete()
                .uri("api/v1/books/%s".formatted("Penguin Inc."))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
