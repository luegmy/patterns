package com.demo.pattern.factory.shop;

import com.demo.pattern.strategy.payment.Payment;
import com.demo.pattern.strategy.payment.PaypalPaymentImpl;

public class Paypal extends Shop{
    @Override
    Payment makePayment() {
        return new PaypalPaymentImpl();

    }
}
