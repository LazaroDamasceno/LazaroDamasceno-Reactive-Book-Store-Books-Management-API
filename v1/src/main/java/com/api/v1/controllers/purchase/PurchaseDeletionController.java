package com.api.v1.controllers.purchase;

import com.api.v1.services.purchase.PurchaseDeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/purchases")
public class PurchaseDeletionController {

    @Autowired
    private PurchaseDeletionService service;

}
