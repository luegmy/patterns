package com.demo.pattern.strategy;


import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.model.strategy.PaymentType;

public interface PaymentService {

  PaymentType getPaymentType();
  void processPayment(PaymentInformation paymentInformation);
}
