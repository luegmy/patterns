package com.demo.startegy.pattern.controller;

import com.demo.startegy.pattern.context.PaymentContext;
import com.demo.startegy.pattern.model.PaymentInformation;
import com.demo.startegy.pattern.model.PaymentType;
import com.demo.startegy.pattern.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/pattern")
public class PaymentController {

    private final PaymentContext paymentContext;

    @PostMapping()
    public void getPayment(@RequestBody PaymentInformation paymentInformation) {
        paymentContext.validateAndProcessPayment(paymentInformation);
    }
}
