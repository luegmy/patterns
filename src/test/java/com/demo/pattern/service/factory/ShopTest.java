package com.demo.pattern.service.factory;

import com.demo.pattern.factory.shop.Cash;
import com.demo.pattern.factory.shop.Paypal;
import com.demo.pattern.factory.shop.Shop;
import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.model.strategy.PaymentType;
import com.demo.pattern.strategy.payment.Payment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ShopTest {

    @Mock
    Payment payment;
    @InjectMocks
    Shop shop = new Paypal();

    @Test
    void testShop() {

        shop.buySomething(new PaymentInformation());

        verify(payment, times(0)).getPaymentType();
        verify(payment, times(0)).processPayment(any());
    }
}
