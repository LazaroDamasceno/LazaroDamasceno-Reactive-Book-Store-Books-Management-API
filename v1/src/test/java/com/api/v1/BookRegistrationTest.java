package com.api.v1;

import com.api.v1.dtos.requests.NewBookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookRegistrationTest {

    @Autowired
    private WebTestClient webTestClient;

    void testSuccessfulBookRegistration() {

        var registrationRequest = new NewBookRequestDto(
                "Harry Potter",
                "",
                "J.K. Rowling",
                "juvenile fantasy",
                300,
                1,
                120.0,
                "Penguin Inc.",
                1997
        );

        webTestClient
                .post()
                .uri("api/v1/books")
                .bodyValue(registrationRequest)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

    }

}
