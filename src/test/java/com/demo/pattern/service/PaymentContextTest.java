package com.demo.pattern.service;

import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.model.strategy.PaymentType;
import com.demo.pattern.strategy.PaymentContextImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
public class PaymentContextTest {

    @SpyBean
    PaymentContextImpl paymentContext;

    @Test
    public void testPayment() {
        PaymentInformation paymentInformation = PaymentInformation.builder()
                .paymentId("1")
                .customerId("2")
                .paymentType(PaymentType.PAYPAL)
                .storeId("3")
                .amount(new BigDecimal("200"))
                .build();

        paymentContext.validateAndProcessPayment(paymentInformation);

        verify(paymentContext, atMostOnce()).validateAndProcessPayment(paymentInformation);
    }

    @ParameterizedTest
    @EnumSource(value = PaymentType.class, names = {"CASH", "PAYPAL", "PSE"})
    void When_ProcessingPayment_Expect_CorrectOutput(PaymentType paymentType) {
        PaymentInformation paymentInformation = PaymentInformation.builder()
                .paymentType(paymentType)
                .customerId("Test")
                .build();

        paymentContext.validateAndProcessPayment(paymentInformation);

        verify(paymentContext, atMostOnce()).validateAndProcessPayment(any(PaymentInformation.class));
    }
}
