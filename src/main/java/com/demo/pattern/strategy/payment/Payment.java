package com.demo.pattern.strategy.payment;


import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.model.strategy.PaymentType;

public interface Payment {

  PaymentType getPaymentType();
  void processPayment(PaymentInformation paymentInformation);
}
