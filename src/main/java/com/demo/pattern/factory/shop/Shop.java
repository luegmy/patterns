package com.demo.pattern.factory.shop;

import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.strategy.payment.Payment;

public abstract class Shop {

    public void buySomething(PaymentInformation paymentInformation) {
        makePayment().processPayment(paymentInformation);
    }

    abstract Payment makePayment();
}
