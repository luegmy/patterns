package com.demo.pattern.service.factory;

import com.demo.pattern.factory.payment.PaymentFactory;
import com.demo.pattern.factory.payment.PaymentFactoryImpl;
import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.model.strategy.PaymentType;
import com.demo.pattern.strategy.payment.CashPaymentImpl;
import com.demo.pattern.strategy.payment.Payment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PaymentFactoryTest {

    @Mock
    Payment payment;
    @InjectMocks
    PaymentFactoryImpl factory;

    @Test
    void testWhenTypePaymentCash() {
        PaymentInformation paymentInformation = PaymentInformation.builder()
                .paymentId("1")
                .customerId("2")
                .paymentType(PaymentType.PAYPAL)
                .storeId("3")
                .amount(new BigDecimal("200"))
                .build();

        Payment result = factory.getPayment(paymentInformation);

        assertEquals(PaymentType.PAYPAL, result.getPaymentType());

        verify(payment, times(0)).getPaymentType();
        verify(payment, times(0)).processPayment(any());
    }
}
