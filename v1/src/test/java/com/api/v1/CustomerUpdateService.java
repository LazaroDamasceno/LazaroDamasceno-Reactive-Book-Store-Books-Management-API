package com.api.v1;

import com.api.v1.dtos.requests.NewCustomerRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerUpdateService {
    
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulCustomerUpdate() {

        var newCustomer = new NewCustomerRequestDto(
                "Leo",
                "Silva",
                "Santos Jr",
                "123456789",
                LocalDate.parse("2000-12-12"),
                "jr@leosantos.com",
                "St. Dennis, Paris, Europe",
                "0987654321",
                "cis male"
        );

        webTestClient
                .put()
                .uri("api/v1/customers")
                .bodyValue(newCustomer)
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulCustomerUpdate() {

        var newCustomer = new NewCustomerRequestDto(
                "Leo",
                "",
                "Santos Jr",
                "123456788",
                LocalDate.parse("2000-12-12"),
                "jr@leosantos.com",
                "St. Dennis, Paris, Europe",
                "0987654321",
                "cis male"
        );

        webTestClient
                .put()
                .uri("api/v1/customers")
                .bodyValue(newCustomer)
                .exchange()
                .expectStatus().is5xxServerError();
    }
    
}
