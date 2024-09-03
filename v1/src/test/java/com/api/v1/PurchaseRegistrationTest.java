package com.api.v1;

import com.api.v1.domain.entities.Book;
import com.api.v1.domain.entities.Customer;
import com.api.v1.domain.entities.Purchase;
import com.api.v1.utils.book.BookFinderUtil;
import com.api.v1.utils.customer.CustomerFinderUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PurchaseRegistrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired

    private BookFinderUtil bookFinderUtil;

    @Autowired
    private CustomerFinderUtil customerFinderUtil;

    @Test
    void testSuccessfulPurchaseRegistration() {

        Book book = bookFinderUtil.find("123456789012").block();
        Customer customer = customerFinderUtil.find("123456789").block();
        Purchase purchase = new Purchase(book, customer, "California");

        webTestClient
                .post()
                .uri("api/v1/purchases")
                .bodyValue(purchase)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

}
