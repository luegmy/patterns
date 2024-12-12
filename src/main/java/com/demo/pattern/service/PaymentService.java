package com.demo.pattern.service;


import com.demo.pattern.model.PaymentInformation;
import com.demo.pattern.model.PaymentType;

public interface PaymentService {

  PaymentType getPaymentType();
  void processPayment(PaymentInformation paymentInformation);
}
