package com.demo.pattern.service.strategy;

import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.model.strategy.PaymentType;
import com.demo.pattern.strategy.payment.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PurchaseServiceTest {

    @Mock
    Payment payment;

    @Spy
    List<Payment> payments = List.of(
            new CashPaymentImpl(),
            new PaypalPaymentImpl(),
            new PsePaymentImpl()
    );

    @InjectMocks
    PurchaseServiceImpl purchaseService;


    @Test
    public void testPayment() {
        PaymentInformation paymentInformation = PaymentInformation.builder()
                .paymentId("1")
                .customerId("2")
                .paymentType(PaymentType.CASH)
                .storeId("3")
                .amount(new BigDecimal("200"))
                .build();

        purchaseService.validateAndProcessPayment(paymentInformation);

        verify(payment, times(0)).getPaymentType();
        verify(payment, times(0)).processPayment(any());
    }

    @ParameterizedTest
    @EnumSource(value = PaymentType.class, names = {"CASH", "PAYPAL", "PSE"})
    void When_ProcessingPayment_Expect_CorrectOutput(PaymentType paymentType) {
        PaymentInformation paymentInformation = PaymentInformation.builder()
                .paymentType(paymentType)
                .customerId("Test")
                .build();

        purchaseService.validateAndProcessPayment(paymentInformation);

        verify(purchaseService, atMostOnce()).validateAndProcessPayment(any(PaymentInformation.class));
    }
}
