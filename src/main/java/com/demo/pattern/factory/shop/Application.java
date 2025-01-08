package com.demo.pattern.factory.shop;

import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.model.strategy.PaymentType;

import java.math.BigDecimal;

public class Application {
    static Shop shop;

    public static void main(String[] args) {

        PaymentInformation paymentInformation = PaymentInformation.builder()
                .paymentId("1")
                .customerId("2")
                .paymentType(PaymentType.PSE)
                .storeId("3")
                .amount(new BigDecimal("200"))
                .build();

        configure(paymentInformation);
        goShopping(paymentInformation);
    }

    static void configure(PaymentInformation paymentInformation) {

        if ("cash".equalsIgnoreCase(paymentInformation.getPaymentType().toString())) {
            shop = new Cash();
        } else if ("paypal".equalsIgnoreCase(paymentInformation.getPaymentType().toString())) {
            shop = new Paypal();
        } else {
            shop = new Pse();
        }
    }

    static void goShopping(PaymentInformation paymentInformation) {
        shop.buySomething(paymentInformation);
    }
}