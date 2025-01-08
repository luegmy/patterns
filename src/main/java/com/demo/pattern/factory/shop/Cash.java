package com.demo.pattern.factory.shop;

import com.demo.pattern.strategy.payment.CashPaymentImpl;
import com.demo.pattern.strategy.payment.Payment;

public class Cash extends Shop{
    @Override
    Payment makePayment() {
        return new CashPaymentImpl();
    }
}
