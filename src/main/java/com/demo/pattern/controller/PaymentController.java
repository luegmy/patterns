package com.demo.pattern.controller;

import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.strategy.payment.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/pattern")
public class PaymentController {

    private final PurchaseService purchaseService;

    @PostMapping()
    public void getPayment(@RequestBody PaymentInformation paymentInformation) {
        purchaseService.validateAndProcessPayment(paymentInformation);
    }
}
