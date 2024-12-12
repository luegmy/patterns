package com.demo.startegy.pattern.context;

import com.demo.startegy.pattern.model.PaymentInformation;

public interface PaymentContext {
    void validateAndProcessPayment(PaymentInformation paymentInformation);
}
