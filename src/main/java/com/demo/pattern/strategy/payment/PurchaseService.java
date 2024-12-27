package com.demo.pattern.strategy.payment;

import com.demo.pattern.model.strategy.PaymentInformation;

public interface PurchaseService {
    void validateAndProcessPayment(PaymentInformation paymentInformation);
}
