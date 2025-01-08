package com.demo.pattern.service.factory;

import com.demo.pattern.factory.payment.PaymentFactory;
import com.demo.pattern.factory.payment.PaymentFactoryImpl;
import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.model.strategy.PaymentType;
import com.demo.pattern.strategy.payment.CashPaymentImpl;
import com.demo.pattern.strategy.payment.Payment;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentFactoryTest {

    PaymentFactory factory= new PaymentFactoryImpl();

    @Test
    void testWhenTypePaymentCash(){
        PaymentInformation paymentInformation = PaymentInformation.builder()
                .paymentId("1")
                .customerId("2")
                .paymentType(PaymentType.CASH)
                .storeId("3")
                .amount(new BigDecimal("200"))
                .build();

        Payment payment = factory.getPayment(paymentInformation);

        assertThat(payment).isOfAnyClassIn(CashPaymentImpl.class);
    }
}
