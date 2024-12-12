package com.demo.pattern.context;

import com.demo.pattern.model.PaymentInformation;

public interface PaymentContext {
    void validateAndProcessPayment(PaymentInformation paymentInformation);
}
