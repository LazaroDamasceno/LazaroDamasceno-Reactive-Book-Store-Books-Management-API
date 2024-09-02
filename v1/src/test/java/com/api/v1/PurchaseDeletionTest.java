package com.api.v1;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PurchaseDeletionTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulPurchaseDeleteById() {
        ObjectId id = null;
        webTestClient
                .delete()
                .uri("api/v1/purchases/%s".formatted(id))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulPurchaseDeleteById() {
        ObjectId id = null;
        webTestClient
                .delete()
                .uri("api/v1/purchases/%s".formatted(id))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    void testSuccessfulAllPurchasesDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/purchases")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulAllPurchasesDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/purchases")
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
