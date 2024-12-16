package com.demo.pattern.strategy;

import com.demo.pattern.model.strategy.PaymentInformation;

public interface PaymentContext {
    void validateAndProcessPayment(PaymentInformation paymentInformation);
}
