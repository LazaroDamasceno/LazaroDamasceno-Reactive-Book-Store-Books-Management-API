package com.api.v1.controllers.customer;

import com.api.v1.services.customer.CustomersDeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/customers")
public class CustomersDeletionController {

    @Autowired
    private CustomersDeletionService service;

    @DeleteMapping("obliteration")
    public Mono<Void> deleteAll() {
        return service.deleteAll();
    }

    @DeleteMapping("{ssn}/obliteration")
    public Mono<Void> deleteBySsn(@PathVariable String ssn) {
        return service.deleteBySsn(ssn);
    }

}
