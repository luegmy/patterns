package com.demo.pattern.factory.payment;

import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.strategy.payment.Payment;

public interface PaymentFactory {

    Payment getPayment(PaymentInformation paymentInformation);
}
