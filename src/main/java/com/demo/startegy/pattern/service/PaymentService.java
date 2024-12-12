package com.demo.startegy.pattern.service;


import com.demo.startegy.pattern.model.PaymentInformation;
import com.demo.startegy.pattern.model.PaymentType;

public interface PaymentService {

  PaymentType getPaymentType();
  void processPayment(PaymentInformation paymentInformation);
}
