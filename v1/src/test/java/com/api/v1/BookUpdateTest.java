package com.api.v1;

import com.api.v1.dtos.requests.NewBookRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookUpdateTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulBookUpdate() {

        var updateRequest = new NewBookRequestDto(
                "Harry Potter",
                "And the Philosopher's Stone",
                "123456789012",
                "J.K. Rowling",
                "juvenile fantasy",
                336,
                1,
                170.0,
                "Penguin Inc.",
                1997
        );

        webTestClient
                .put()
                .uri("api/v1/books")
                .bodyValue(updateRequest)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

    }

    @Test
    void testUnsSuccessfulBookUpdate() {

        var updateRequest = new NewBookRequestDto(
                "Harry Potter",
                "And the Philosopher's Stone",
                "123456789011",
                "J.K. Rowling",
                "juvenile fantasy",
                336,
                1,
                170.0,
                "Penguin Inc.",
                1997
        );

        webTestClient
                .put()
                .uri("api/v1/books")
                .bodyValue(updateRequest)
                .exchange()
                .expectStatus()
                .is5xxServerError();

    }

}
