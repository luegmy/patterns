package com.demo.pattern.factory.shop;

import com.demo.pattern.strategy.payment.Payment;
import com.demo.pattern.strategy.payment.PsePaymentImpl;

public class Pse extends Shop{
    @Override
    Payment makePayment() {
        return new PsePaymentImpl();
    }
}
