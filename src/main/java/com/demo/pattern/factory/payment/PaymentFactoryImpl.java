package com.demo.pattern.factory.payment;

import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.model.strategy.PaymentType;
import com.demo.pattern.strategy.payment.CashPaymentImpl;
import com.demo.pattern.strategy.payment.Payment;
import com.demo.pattern.strategy.payment.PaypalPaymentImpl;
import com.demo.pattern.strategy.payment.PsePaymentImpl;

public class PaymentFactoryImpl implements PaymentFactory {
    @Override
    public Payment getPayment(PaymentInformation paymentInformation) {
        if (PaymentType.CASH.equals(paymentInformation.getPaymentType())) {
            return new CashPaymentImpl();
        }
        if (PaymentType.PAYPAL.equals(paymentInformation.getPaymentType())) {
            return new PaypalPaymentImpl();
        }
        return new PsePaymentImpl();

    }
}
